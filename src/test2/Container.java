package test2;

import java.util.ArrayList;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;

public class Container extends ElementState
{

	@simpl_scope("itemScope1")
	@simpl_collection
	ArrayList<ItemBase>	itemCollection1;

	@simpl_scope("itemScope2")
	@simpl_collection
	ArrayList<ItemBase>	itemCollection2;

	public Container()
	{
		
	}
	
	public void populateContainer()
	{
		itemCollection1 = new ArrayList<ItemBase>();
		itemCollection2 = new ArrayList<ItemBase>();

		itemCollection1.add(new ItemOne(1, 1));
		itemCollection1.add(new ItemOne(1, 2));
		itemCollection1.add(new ItemOne(1, 3));
		itemCollection1.add(new ItemTwo("one", 1));
		itemCollection1.add(new ItemTwo("two", 2));
		itemCollection1.add(new ItemTwo("three", 3));

		itemCollection2.add(new ItemTwo("one", 1));
		itemCollection2.add(new ItemTwo("two", 2));
		itemCollection2.add(new ItemTwo("three", 3));
		itemCollection2.add(new ItemRandom("four", 4));
		itemCollection2.add(new ItemRandom("five", 5));
		itemCollection2.add(new ItemRandom("six", 6)); 
	}

	public static void main(String args[]) throws SIMPLTranslationException
	{
		
		StringBuilder output = new StringBuilder();
		Container c = new Container();
		c.populateContainer();
		
		c.serialize(output);
		
		System.out.println(output);

		TranslationScope itemTranslationScope = TranslationScope.get("itemScope1", ItemBase.class,
				ItemOne.class, ItemTwo.class);

		TranslationScope itemTranslationScope2 = TranslationScope.get("itemScope2", ItemBase.class,
				ItemRandom.class, ItemTwo.class);
		
		TranslationScope containerTranslationScope = TranslationScope.get("containerScope",
				Container.class, ItemBase.class, ItemOne.class, ItemTwo.class, ItemRandom.class);
		
		Container deserializedContainer = (Container) containerTranslationScope.deserializeCharSequence(output);

		System.out.println();
		System.out.println();
		
		
		deserializedContainer.serialize(System.out);
		
		deserializedContainer = (Container) containerTranslationScope.deserializeCharSequence(output);

		System.out.println();
		System.out.println();
		
		deserializedContainer.serialize(System.out);
		
	}
}
