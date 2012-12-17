package tests;

import ecologylab.serialization.SimplTypesScope;

public class SimplTestObject {
	String name;
	Object instance;
	SimplTypesScope deSlashSerializationScope;
	public SimplTestObject(String name, Object instance,
			SimplTypesScope deSlashSerializationScope)
		{
		super();
		this.name = name;
		this.instance = instance;
		this.deSlashSerializationScope = deSlashSerializationScope;
	}	
}
