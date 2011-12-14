package tests.circle;

import java.io.File;
import java.io.IOException;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.annotations.Hint;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_hints;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.formatenums.Format;
import ecologylab.translators.cocoa.CocoaTranslationException;
import ecologylab.translators.cocoa.CocoaTranslator;

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
		
		
		SimplTypesScope t = SimplTypesScope.get("circleTScope", Circle.class, Point.class);
		
		TestingUtils.generateCocoaClasses(t);
		
		SimplTypesScope.enableGraphSerialization();

		TestingUtils.test(c, SimplTypesScope.get("circle", Circle.class, Point.class), Format.XML);
		
		TestingUtils.test(c, SimplTypesScope.get("circle", Circle.class, Point.class), Format.JSON);
		TestingUtils.test(c, SimplTypesScope.get("circle", Circle.class, Point.class), Format.TLV);
	}
}
