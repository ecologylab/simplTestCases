package tests.graph;

import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_scalar;

public class ClassB
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

	public void initializeInstance()
	{
		setA(4);
		setB(5);
		setClassA(new ClassA(this));
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
}
