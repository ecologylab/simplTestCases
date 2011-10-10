package tests.scalar;

import java.util.ArrayList;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.Format;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_collection;

public class ScalarCollection implements TestCase
{
	@simpl_collection("circles")
	private ArrayList<Integer>	collectionOfIntegers;

	public ScalarCollection()
	{
		collectionOfIntegers = new ArrayList<Integer>();
	}

	public void addInt(int integer)
	{
		collectionOfIntegers.add(integer);
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		ScalarCollection sc = new ScalarCollection();

		sc.addInt(1);
		sc.addInt(2);
		sc.addInt(3);
		sc.addInt(4);
		sc.addInt(5);

		TranslationScope scalarCollectionTranslationScope = TranslationScope.get(
				"scalarCollectionTScope", ScalarCollection.class);

		TestingUtils.test(sc, scalarCollectionTranslationScope, Format.XML);

		TestingUtils.test(sc, scalarCollectionTranslationScope, Format.JSON);
	}
}