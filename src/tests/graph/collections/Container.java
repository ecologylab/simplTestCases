package tests.graph.collections;

import java.util.ArrayList;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_collection;

public class Container implements TestCase
{
	
	@simpl_collection("objectsA")
	private ArrayList<ClassA>	aObjects	= new ArrayList<ClassA>();

	public Container()
	{

	}

	public Container initializeInstance()
	{
		ClassA objA = new ClassA();

		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);
		aObjects.add(objA);

		aObjects.add(new ClassA());
		aObjects.add(new ClassA());

		return this;
	}

	public void setAobjects(ArrayList<ClassA> aobjects)
	{
		aObjects = aobjects;
	}

	public ArrayList<ClassA> getAobjects()
	{
		return aObjects;
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		TranslationScope.enableGraphSerialization();

		Container test = new Container().initializeInstance();
		TranslationScope translationScope = TranslationScope.get("testcollection", Container.class,
				ClassA.class);

		TestingUtils.test(test, translationScope, StringFormat.XML);
		TestingUtils.test(test, translationScope, StringFormat.JSON);

		TranslationScope.disableGraphSerialization();

	}

}