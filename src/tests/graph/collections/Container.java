package tests.graph.collections;

import java.util.ArrayList;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.annotations.simpl_collection;
import ecologylab.serialization.formatenums.Format;

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
		SimplTypesScope.enableGraphSerialization();

		Container test = new Container().initializeInstance();
		SimplTypesScope translationScope = SimplTypesScope.get("testcollection", Container.class,
				ClassA.class);

		TestingUtils.test(test, translationScope, Format.XML);
		TestingUtils.test(test, translationScope, Format.JSON);
		TestingUtils.test(test, translationScope, Format.TLV);

		SimplTypesScope.disableGraphSerialization();

	}

}
