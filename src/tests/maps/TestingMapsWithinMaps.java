package tests.maps;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;

public class TestingMapsWithinMaps implements TestCase
{
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

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		TranslationScope.enableGraphSerialization();

		TranslationS test = createObject();
		TranslationScope tScope = TranslationScope.get("testScope", TranslationS.class, ClassDes.class,
				FieldDes.class);

		TestingUtils.test(test, tScope, StringFormat.XML);
		TestingUtils.test(test, tScope, StringFormat.JSON);

		TranslationScope.disableGraphSerialization();

	}
}
