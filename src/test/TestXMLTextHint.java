/**
 * 
 */
package test;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.library.jnlp.information.Description;

/**
 * @author Zachary O. Toups (zach@ecologylab.net)
 *
 */
public class TestXMLTextHint
{
  public static void main(String[] args) throws SIMPLTranslationException
  {
  	String descChunk = "<description kind=\"short\">A demo of the capabilities of the Swing Graphical User Interface.</description>";
  	
  	Description descObj = (Description) TranslationScope.get("JNLPDesc", Description.class).deserializeCharSequence(descChunk);
  	
  	System.out.println(descChunk);
  	descObj.serialize(System.out);
  }
}