package tests.graph;

import java.io.IOException;

import tests.TestCase;
import tests.TestingUtils;
import tests.circle.Point;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.Hint;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_hints;
import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.serializers.enums.Format;

@simpl_inherit
public class ClassA implements TestCase
{
	@simpl_scalar
	private int			x;

	@simpl_scalar
	private int			y;

	@simpl_composite
	private ClassB	classB;

	@simpl_composite
	private ClassA	classA;

	public ClassA()
	{

	}

	public ClassA(int x, int y)
	{
		setX(x);
		setY(y);
		setClassA(this);
	}

	public ClassA(int x, int y, ClassB classB)
	{
		setX(x);
		setY(y);
		setClassB(classB);
		setClassA(this);
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getY()
	{
		return y;
	}

	public void setClassB(ClassB classB)
	{
		this.classB = classB;
	}

	public ClassB getClassB()
	{
		return classB;
	}

	public void setClassA(ClassA classA)
	{
		this.classA = classA;
	}

	public ClassA getClassA()
	{
		return classA;
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		TranslationScope.enableGraphSerialization();

		ClassA test = new ClassA(1, 2);
		ClassB classB = new ClassB(3, 4, test);

		test.setClassB(classB);

		TranslationScope tScope = TranslationScope.get("classA", ClassA.class, ClassB.class);

		TestingUtils.test(test, tScope, Format.XML);
		TestingUtils.test(test, tScope, Format.JSON);

		TranslationScope.disableGraphSerialization();
	}
}
