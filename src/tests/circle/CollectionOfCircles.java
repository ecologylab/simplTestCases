package tests.circle;

import java.util.ArrayList;

import tests.TestCase;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.Hint;
import ecologylab.serialization.annotations.simpl_collection;
import ecologylab.serialization.annotations.simpl_hints;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.serializers.Format;

public class CollectionOfCircles extends TestCase
{
	@simpl_collection("circles")
	private ArrayList<Circle>	collectionOfCircles;

	@simpl_hints(Hint.XML_LEAF)
	@simpl_scalar
	int												yo	= 1;

	public CollectionOfCircles()
	{
		collectionOfCircles = new ArrayList<Circle>();
	}

	public void addCircle(int r, int x, int y)
	{
		collectionOfCircles.add(new Circle(r, x, y));
	}

	@Override
	public void runTest()
	{
		CollectionOfCircles coc = new CollectionOfCircles();

		coc.addCircle(1, 2, 3);
		coc.addCircle(1, 2, 4);
		coc.addCircle(1, 2, 5);
		coc.addCircle(1, 2, 6);
		coc.addCircle(1, 2, 7);

		TranslationScope circleTranslationScope = TranslationScope.get("circleTScope",
				CollectionOfCircles.class, Circle.class, Point.class);

		test(coc, circleTranslationScope, Format.XML);

		test(coc, circleTranslationScope, Format.JSON);
	}
}
