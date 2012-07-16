package tests.generics.dotnetcodegen;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import tests.generics.FlickrSearchResult;
import tests.generics.Image;
import tests.generics.ImageSearch;
import tests.generics.Media;
import tests.generics.MediaSearch;
import tests.generics.MediaSearchResult;
import tests.generics.Search;
import tests.generics.SearchResult;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.translators.CodeTranslationException;
import ecologylab.translators.CodeTranslator;
import ecologylab.translators.CodeTranslatorConfig;
import ecologylab.translators.net.DotNetTranslator;

public class TestGeneratingDotNetCode
{
	
	static Class[] classes = {
		SearchResult.class,
		Search.class,
		Media.class,
		MediaSearchResult.class,
		MediaSearch.class,
		Image.class,
		FlickrSearchResult.class,
		ImageSearch.class,
	};
	
	public static SimplTypesScope getTestingTypesScope()
	{
		return SimplTypesScope.get("test-simpl-generics", classes);
	}

	@Test
	public void testGeneratingBasics() throws IOException, SIMPLTranslationException, CodeTranslationException
	{
		SimplTypesScope scope = getTestingTypesScope();
		CodeTranslator t = new DotNetTranslator();
		CodeTranslatorConfig config = new CodeTranslatorConfig();
		config.setLibraryTScopeClassPackage("Simpl.Test.Generics");
		config.setLibraryTScopeClassSimpleName("GenericsTestingScope");
		t.translate(new File("../../CSharp/TestSimplTranslators/"), scope, config);
	}

}
