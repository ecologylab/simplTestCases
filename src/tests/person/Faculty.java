package tests.person;

import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.*;
import ecologylab.serialization.serializers.Format;

@simpl_inherit
public
class Faculty extends Person
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
	public void runTest()
	{
		Faculty f = new Faculty("andruid", "professor");
		test(f, TranslationScope.get("faculty", Person.class, Faculty.class), Format.XML);
		test(f, TranslationScope.get("faculty", Person.class, Faculty.class), Format.JSON);
	}
}
