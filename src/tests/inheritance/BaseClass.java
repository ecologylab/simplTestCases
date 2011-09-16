package tests.inheritance;

import ecologylab.serialization.annotations.simpl_other_tags;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.annotations.simpl_tag;

@simpl_other_tags({"the_field"})
@simpl_tag("fred")
public class BaseClass
{
	@simpl_tag("new_tag_var")
	@simpl_other_tags("other_tag_var")
	@simpl_scalar
	int var = 3;
	
	public BaseClass()
	{
	}
}
