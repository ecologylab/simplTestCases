package tests;

import java.io.IOException;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.serializers.Format;

public class TestingUtils
{
	public static void testSerailization(Object object, Format format) throws SIMPLTranslationException, IOException
	{

		ClassDescriptor.serialize(object, System.out, format);

		System.out.println();
	}

	public static void testSerailization(Object object, StringBuilder sb, Format format)
	{
		try
		{
			ClassDescriptor.serialize(object, sb, format);
			System.out.println(sb);
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
	}

	public static void testDeserailization(StringBuilder sb, TranslationScope translationScope,
			Format format)
	{
		try
		{
			Object object = translationScope.deserializeCharSequence(sb, format);
			testSerailization(object, format);
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
	}

	public static void test(Object object, TranslationScope translationScope, Format format)
	{
		StringBuilder sb = new StringBuilder();
		testSerailization(object, sb, format);
		testDeserailization(sb, translationScope, format);

		System.out.println();
	}
}
