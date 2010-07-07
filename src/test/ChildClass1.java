package test;

import ecologylab.xml.Hint;

public class ChildClass1 extends BaseClass
{
	@simpl_scalar @simpl_hints(Hint.XML_LEAF)
	int ccvar1 = 1;
	
	public ChildClass1()
	{
	}
}
