package tests.person;

import java.util.ArrayList;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.Format;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.Hint;
import ecologylab.serialization.annotations.simpl_collection;
import ecologylab.serialization.annotations.simpl_hints;
import ecologylab.serialization.annotations.simpl_nowrap;
import ecologylab.serialization.annotations.simpl_scalar;

public class StudentDirectory implements TestCase
{	
	@simpl_nowrap
	@simpl_collection("student")
	private ArrayList<Student>	students	= new ArrayList<Student>();
	
	
	@simpl_hints(Hint.XML_LEAF)
	@simpl_scalar
	String test = null;
	
	public StudentDirectory()
	{
		this.setStudents(new ArrayList<Student>());
	}

	public void setStudents(ArrayList<Student> students)
	{
		this.students = students;
	}

	public ArrayList<Student> getStudents()
	{
		return students;
	}

	public void initializeDirectory()
	{
		students.add(new Student("nabeel", "234342"));
		students.add(new Student("yin", "423423"));
		students.add(new Student("bill", "4234234"));
		students.add(new Student("sashi", "5454"));
		students.add(new Student("jon", "656565"));
		
		test = "nabel";
		
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		StudentDirectory s = new StudentDirectory();
		s.initializeDirectory();

		TestingUtils.test(s, TranslationScope.get("studentDir", Person.class, Student.class,
				StudentDirectory.class), Format.XML);
		TestingUtils.test(s, TranslationScope.get("studentDir", Person.class, Student.class,
				StudentDirectory.class), Format.JSON);
	}
}