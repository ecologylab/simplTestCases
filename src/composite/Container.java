package composite;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;

public class Container extends ElementState
{

	@simpl_wrap
	@simpl_composite
	@simpl_classes({WCBase.class, WCSubOne.class, WCSubTwo.class})
	WCBase wc;
	
	
	public Container()
	{
		wc = new WCBase(0);
	}
	
	/**
	 * @param args
	 * @throws SIMPLTranslationException 
	 */
	public static void main(String[] args) throws SIMPLTranslationException
	{
		StringBuilder sb = new StringBuilder();	
		Container c = new Container();
		
//		c.wc = new WCBase(224234);
		
		c.wc = new WCSubTwo(true);
		
		c.serialize(sb);
		
		System.out.println(sb);
		
		TranslationScope containerTest = TranslationScope.get("containerTranslationscope", Container.class, WCBase.class, WCSubOne.class, WCSubTwo.class);
		Container deserializedContainer = (Container) containerTest.deserializeCharSequence(sb.toString());
		
		System.out.println();
		deserializedContainer.serialize(System.out);
	}
}
