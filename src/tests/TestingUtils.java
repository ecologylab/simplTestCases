package tests;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;

public class TestingUtils
{
	public static void testSerailization(Object object, StringFormat format) throws SIMPLTranslationException
	{
		ClassDescriptor.serialize(object, System.out, format);
		System.out.println();
	}

	public static void testSerailization(Object object, StringBuilder sb, StringFormat format) throws SIMPLTranslationException
	{		
			ClassDescriptor.serialize(object, sb, format);
			System.out.println(sb);	
	}

	public static void testDeserailization(StringBuilder sb, TranslationScope translationScope,
			StringFormat format) throws SIMPLTranslationException
	{		
			Object object = translationScope.deserialize(sb, format);
			testSerailization(object, format);		
	}

	public static void test(Object object, TranslationScope translationScope, StringFormat format) throws SIMPLTranslationException
	{
		StringBuilder sb = new StringBuilder();
		testSerailization(object, sb, format);
		testDeserailization(sb, translationScope, format);

		System.out.println();
	}
}
