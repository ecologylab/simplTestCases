package tests.graph.diamond;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_composite;

public class ClassD implements TestCase
{
	@simpl_composite
	private ClassA	classA;

	@simpl_composite
	private ClassB	classB;

	public ClassD()
	{

	}

	public ClassD(ClassA classA, ClassB classB)
	{
		this.setClassA(classA);
		this.setClassB(classB);
	}

	public void setClassA(ClassA classA)
	{
		this.classA = classA;
	}

	public ClassA getClassA()
	{
		return classA;
	}

	public void setClassB(ClassB classB)
	{
		this.classB = classB;
	}

	public ClassB getClassB()
	{
		return classB;
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		TranslationScope.enableGraphSerialization();

		ClassC classC = new ClassC();
		ClassD test = new ClassD(new ClassA(classC), new ClassB(classC));

		TranslationScope tScope = TranslationScope.get("classD", ClassA.class, ClassB.class,
				ClassC.class, ClassD.class, ClassX.class);

		TestingUtils.test(test, tScope, StringFormat.XML);
		TestingUtils.test(test, tScope, StringFormat.JSON);

		TranslationScope.disableGraphSerialization();
	}
}