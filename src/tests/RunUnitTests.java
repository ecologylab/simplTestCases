package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ecologylab.serialization.SIMPLTranslationException;

import tests.bibtex.Article;
import tests.circle.Circle;
import tests.circle.CollectionOfCircles;
import tests.circle.Point;
import tests.configuration.Configuration;
import tests.graph.ClassA;
import tests.graph.ClassB;
import tests.graph.collections.Container;
import tests.graph.diamond.ClassD;
import tests.maps.TestingMapsWithinMaps;
import tests.person.Faculty;
import tests.person.Person;
import tests.person.PersonDirectory;
import tests.person.Student;
import tests.person.StudentDirectory;
import tests.rss.Rss;
import tests.scalar.ScalarCollection;

public class RunUnitTests
{

	@Test
	public void scalarTest()
	{
		runTestCase(new Point());
	}
	
	@Test
	public void compositeTest()
	{
		runTestCase(new Circle());
	}
	
	@Test
	public void collectionTest()
	{
		runTestCase(new CollectionOfCircles());
	}
	
	@Test
	public void inheritenceTest()
	{
		runTestCase(new Person());
		runTestCase(new Faculty());
		runTestCase(new Student());
	}
	
	@Test 
	public void RssTest()
	{
		runTestCase(new Rss());
	}
	
	@Test
	public void monoMorphicCollectionTest()
	{
		runTestCase(new StudentDirectory());
	}
	
	@Test
	public void polymophicCollectionTest()
	{
		runTestCase(new PersonDirectory());
		runTestCase(new Configuration());
	}
	
	@Test
	public void graphTest()
	{
		runTestCase(new ClassA());
		runTestCase(new ClassB());
		runTestCase(new ClassD());
		runTestCase(new Container());
	}
	
	@Test
	public void scalarCollectionTest()
	{
		runTestCase(new ScalarCollection());
	}
	
	@Test
	public void mapsTest()
	{
		runTestCase(new TestingMapsWithinMaps());
	}
	
	@Test
	public void articleTest()
	{
		runTestCase(new Article());
	}

	public void runTestCase(TestCase testCase)
	{
		try
		{
			testCase.runTest();
		}
		catch (SIMPLTranslationException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
