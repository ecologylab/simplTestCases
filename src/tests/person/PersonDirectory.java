package tests.person;

import java.util.ArrayList;

import tests.TestCase;

import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.*;
import ecologylab.serialization.serializers.Format;

public class PersonDirectory extends TestCase
{
	@simpl_classes(
	{ Student.class, Faculty.class })
	@simpl_collection
	private ArrayList<Person>	persons	= new ArrayList<Person>();

	public PersonDirectory()
	{
		persons = new ArrayList<Person>();
	}

	public void initializeDirectory()
	{
		persons.add(new Student("nabeel", "234342"));
		persons.add(new Student("yin", "423423"));
		persons.add(new Faculty("andruid", "prof"));
		persons.add(new Student("bill", "4234234"));
		persons.add(new Student("sashi", "5454"));
		persons.add(new Student("jon", "656565"));

	}

	public static void main(String args[])
	{
		PersonDirectory p = new PersonDirectory();
		p.initializeDirectory();

		testSerailization(p, Format.XML);
		testSerailization(p, Format.JSON);
	}

	@Override
	public void runTest()
	{
		PersonDirectory p = new PersonDirectory();
		p.initializeDirectory();
		
		TranslationScope translationScope = TranslationScope.get("personDir", Person.class, Faculty.class, Student.class, PersonDirectory.class);

		test(p, translationScope, Format.XML);
		test(p, translationScope, Format.JSON);
	}
}
