package test;

import ecologylab.serialization.annotations.Hint;
import ecologylab.serialization.annotations.simpl_hints;
import ecologylab.serialization.annotations.simpl_scalar;

public class ChildClass2 extends BaseClass
{
	@simpl_scalar @simpl_hints(Hint.XML_LEAF)
	int ccvar2 = 2;
	
	public ChildClass2()
	{
	}
	
}
