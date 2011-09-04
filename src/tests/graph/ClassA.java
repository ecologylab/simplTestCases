package tests.graph;

import java.io.IOException;

import tests.TestCase;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.serializers.Format;

@simpl_inherit
public class ClassA extends TestCase
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

	public ClassA(ClassB classB)
	{
		setX(1);
		setY(2);
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

	/**
	 * @param args
	 * @throws SIMPLTranslationException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SIMPLTranslationException, IOException
	{
		ClassB test = new ClassB();
		test.initializeInstance();
		TranslationScope.setGraphSwitch();
		
		testSerailization(test, Format.XML);
		testSerailization(test, Format.JSON);
	}
}
