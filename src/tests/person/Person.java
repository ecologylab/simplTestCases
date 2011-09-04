package tests.person;

import tests.TestCase;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.serializers.Format;
import ecologylab.serialization.types.element.Mappable;

public class Person extends TestCase implements Mappable<String>
{
	@simpl_scalar
	private String	name;

	public Person()
	{
		name = "";
	}

	public Person(String name)
	{
		this.name = name;
	}

	public void setName(String n)
	{
		name = n;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public void runTest()
	{
		Person p = new Person("nabeel");
		test(p, TranslationScope.get("person", Person.class), Format.XML);
		test(p, TranslationScope.get("person", Person.class), Format.JSON);
	}

	@Override
	public String key()
	{
		return name;
	}
}
