package maps;

import java.util.HashMap;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;

public class TestingMapsWithinMaps
{
	public static void main(String args[]) throws SIMPLTranslationException
	{
		TranslationS trans = createObject();
		StringBuilder output = new StringBuilder();
		
		trans.serialize(output);

		System.out.println(output);
		
		TranslationScope transScope = TranslationScope.get("testScope", TranslationS.class, ClassDes.class, FieldDes.class);
	
		TranslationS deserializedObject = (TranslationS) transScope.deserializeCharSequence(output.toString());
		
		System.out.println();
		
		deserializedObject.serialize(System.out);
	}
	
	public static TranslationS createObject()
	{
		TranslationS trans = new TranslationS();
		
		ClassDes cd1 = new ClassDes("cd1");
		
		cd1.fieldDescriptorsByTagName.put("fd1_cd1", new FieldDes("fd1_cd1"));
		cd1.fieldDescriptorsByTagName.put("fd2_cd1", new FieldDes("fd2_cd1"));
		cd1.fieldDescriptorsByTagName.put("fd3_cd1", new FieldDes("fd3_cd1"));
		
		ClassDes cd2 = new ClassDes("cd2");
		cd2.fieldDescriptorsByTagName.put("fd1_cd2", new FieldDes("fd1_cd2"));
		cd2.fieldDescriptorsByTagName.put("fd2_cd2", new FieldDes("fd2_cd2"));
		cd2.fieldDescriptorsByTagName.put("fd3_cd2", new FieldDes("fd3_cd2"));
		
		
		trans.entriesByTag.put("cd1", cd1);
		trans.entriesByTag.put("cd2", cd2);
		
		
		return trans;
	}
}
