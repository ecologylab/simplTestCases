package tests.graph;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.Format;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_scalar;

public class ClassB implements TestCase
{
	@simpl_scalar
	private int			a;

	@simpl_scalar
	private int			b;

	@simpl_composite
	private ClassA	classA;

	public ClassB()
	{

	}

	public ClassB(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public ClassB(int a, int b, ClassA classA)
	{
		this.a = a;
		this.b = b;
		this.classA = classA;
	}

	public void setClassA(ClassA classA)
	{
		this.classA = classA;
	}

	public ClassA getClassA()
	{
		return classA;
	}

	public void setB(int b)
	{
		this.b = b;
	}

	public int getB()
	{
		return b;
	}

	public void setA(int a)
	{
		this.a = a;
	}

	public int getA()
	{
		return a;
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		TranslationScope.enableGraphSerialization();

		ClassB test = new ClassB(1, 2);
		ClassA classA = new ClassA(3, 4, test);

		test.setClassA(classA);

		TranslationScope tScope = TranslationScope.get("classB", ClassA.class, ClassB.class);

		TestingUtils.test(test, tScope, Format.XML);
		TestingUtils.test(test, tScope, Format.JSON);

		TranslationScope.disableGraphSerialization();
	}
}
