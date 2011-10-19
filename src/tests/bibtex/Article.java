package tests.bibtex;

import java.util.ArrayList;
import java.util.List;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.annotations.simpl_collection;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.formatenums.Format;
import tests.TestCase;
import tests.TestingUtils;

public class Article implements TestCase
{
	@simpl_scalar
	String title;
	
	@simpl_collection("author")
	List<Author> authors;

	
	public Article(String t, List<Author> a)
	{
		title = t;
		authors = a;
	}
	
	public Article()
	{
		
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		Author a1 = new Author("Author One", "City");
		Author a2 = new Author("Author Two", "Place");
		
		ArrayList<Author> authors = new ArrayList<Author>();
		authors.add(a1);
		authors.add(a2);
		
		String title = "Article being serialized";
		
		Article article = new Article(title, authors);
		
		TestingUtils.test(article, SimplTypesScope.get("article", Article.class, Author.class), Format.BIBTEX);		
		
	}

}
