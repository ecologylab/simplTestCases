package tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.Format;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.deserializers.parsers.tlv.Utils;

public class TestingUtils
{

	public static void testSerailization(Object object, OutputStream outStream, Format format)
			throws SIMPLTranslationException
	{
		ClassDescriptor.serialize(object, outStream, format);
	}

	public static void testDeserailization(InputStream inputStream,
			TranslationScope translationScope, Format format) throws SIMPLTranslationException
	{
		Object object = translationScope.deserialize(inputStream, format);
		testSerailization(object, System.out, format);
	}

	public static void test(Object object, TranslationScope translationScope, Format format)
			throws SIMPLTranslationException
	{
		OutputStream output = new OutputStream()
		{
			StringBuilder	string	= new StringBuilder();

			@Override
			public void write(int b) throws IOException
			{
				this.string.append((char) b);
			}
			
			public String toString()
			{
				return this.string.toString();
			}
		};
		
		testSerailization(object, output, format);		
		printString(output.toString(), format);
//		testDeserailization(new ByteArrayInputStream(output.toString().getBytes()), translationScope,
//				format);

		System.out.println();
	}
	
	public static void printString(String string, Format format)
	{
		if(format == Format.TLV)
		{
			Utils.writeHex(System.out, string.getBytes());			
		}
		else
		{
			System.out.println(string);
		}
	}
}
