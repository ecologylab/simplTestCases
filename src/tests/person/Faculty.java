package tests.person;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.Format;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_scalar;

@simpl_inherit
public
class Faculty extends Person implements TestCase
{
	@simpl_scalar
	private String	designation;

	public void setStuNum(String sn)
	{
		designation = sn;
	}

	public String getStuNum()
	{
		return designation;
	}

	public Faculty()
	{
		super();
		this.designation = "";
	}

	public Faculty(String name, String designation)
	{
		super(name);
		this.designation = designation;
	}
	
	@Override
	public void runTest() throws SIMPLTranslationException
	{
		Faculty f = new Faculty("andruid", "professor");
		TestingUtils.test(f, TranslationScope.get("faculty", Person.class, Faculty.class), Format.XML);
		TestingUtils.test(f, TranslationScope.get("faculty", Person.class, Faculty.class), Format.JSON);
	}
}
