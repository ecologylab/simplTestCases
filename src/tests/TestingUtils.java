package tests;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import ecologylab.serialization.Format;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.deserializers.parsers.tlv.Utils;

public class TestingUtils
{

	public static void testSerailization(Object object, DualBufferOutputStream outStream, Format format)
			throws SIMPLTranslationException
	{
		SimplTypesScope.serialize(object, outStream, format);
		printOutput(outStream, format);
	}

	public static void testDeserailization(InputStream inputStream,
			SimplTypesScope translationScope, Format format) throws SIMPLTranslationException
	{
		Object object = translationScope.deserialize(inputStream, format);
		DualBufferOutputStream outputStream = new DualBufferOutputStream();		
		testSerailization(object, outputStream, Format.XML);		
	}

	public static void test(Object object, SimplTypesScope translationScope, Format format)
			throws SIMPLTranslationException
	{
		DualBufferOutputStream outputStream = new DualBufferOutputStream();
		
		testSerailization(object, outputStream, format);		
		
		testDeserailization(new ByteArrayInputStream(outputStream.toByte()), translationScope,
				format);

		System.out.println();
	}
	
	public static void printOutput(DualBufferOutputStream outputStream, Format format)
	{
		if(format == Format.TLV)
		{
			Utils.writeHex(System.out, outputStream.toByte());			
		}
		else
		{
			System.out.println(outputStream.toString());
		}
	}
}
