package tests.person;

import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.StringFormat;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_inherit;
import ecologylab.serialization.annotations.simpl_scalar;

@simpl_inherit
public class Student extends Person
{
	@simpl_scalar
	private String	stuNum;

	public void setStuNum(String sn)
	{
		stuNum = sn;
	}

	public String getStuNum()
	{
		return stuNum;
	}

	public Student()
	{
		super();
		this.stuNum = "";
	}

	public Student(String name, String stuNum)
	{
		super(name);
		this.stuNum = stuNum;
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		Student s = new Student("nabeel", "12343434");
		TestingUtils.test(s, TranslationScope.get("student", Person.class, Student.class), StringFormat.XML);
		TestingUtils.test(s, TranslationScope.get("student", Person.class, Student.class), StringFormat.JSON);
	}
}
