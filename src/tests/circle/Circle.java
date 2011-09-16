package tests.circle;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.Hint;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_hints;
import ecologylab.serialization.annotations.simpl_scalar;

public class Circle implements TestCase
{
	@simpl_hints(Hint.XML_LEAF)
	@simpl_scalar
	int		radius;
	
	@simpl_composite
	Point	center;

	public Circle()
	{
	}

	public Circle(int radius, Point center)
	{
		this.radius = radius;
		this.center = center;
	}

	public Circle(int radius, int x, int y)
	{
		this.radius = radius;
		this.center = new Point(x, y);
	}
	
	@Override
	public void runTest() throws SIMPLTranslationException
	{
		Circle c = new Circle(3, 2, 1);

		TestingUtils.test(c, TranslationScope.get("circle", Circle.class, Point.class), StringFormat.XML);
		
		TestingUtils.test(c, TranslationScope.get("circle", Circle.class, Point.class), StringFormat.JSON);
	}
}
