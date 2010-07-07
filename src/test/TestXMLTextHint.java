/**
 * 
 */
package test;

import ecologylab.xml.ElementState;
import ecologylab.xml.SIMPLTranslationException;
import ecologylab.xml.TranslationScope;
import ecologylab.xml.library.jnlp.information.Description;

/**
 * @author Zachary O. Toups (zach@ecologylab.net)
 *
 */
public class TestXMLTextHint
{
  public static void main(String[] args) throws SIMPLTranslationException
  {
  	String descChunk = "<description kind=\"short\">A demo of the capabilities of the Swing Graphical User Interface.</description>";
  	
  	Description descObj = (Description) ElementState.translateFromXMLCharSequence(descChunk, TranslationScope.get("JNLPDesc", Description.class));
  	
  	System.out.println(descChunk);
  	descObj.serialize(System.out);
  }
}