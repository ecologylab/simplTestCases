package test;

import ecologylab.xml.ElementState;
import ecologylab.xml.xml_inherit;
import ecologylab.xml.ElementState.xml_other_tags;
import ecologylab.xml.ElementState.xml_tag;

@xml_other_tags({"the_field"})
@xml_tag("fred")
public class BaseClass extends ElementState
{
	@xml_tag("new_tag_var")
	@xml_other_tags("other_tag_var")
	@xml_attribute
	int var = 3;
	
	public BaseClass()
	{
	}
}
