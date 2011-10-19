package tests.bibtex;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.formatenums.Format;
import tests.TestCase;
import tests.TestingUtils;

public class Author implements TestCase
{
	@simpl_scalar
	String name;
	
	@simpl_scalar
	String city;
	
	public Author(String n, String c)
	{
		name = n;
		city = c;
	}
	
	public Author()
	{
		
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		Author a = new Author("Test Author", "Example City");
		
		TestingUtils.test(a, SimplTypesScope.get("author", Author.class), Format.BIBTEX);

	}

}
