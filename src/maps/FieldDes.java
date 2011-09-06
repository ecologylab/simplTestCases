package maps;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.annotations.simpl_scalar;
import ecologylab.serialization.types.element.IMappable;

public class FieldDes extends ElementState implements IMappable<String>
{
	@simpl_scalar
	public String	fieldName;
	
	public FieldDes()
	{
		fieldName = "";
	}
	
	public FieldDes(String fieldName)
	{
		this.fieldName = fieldName;
	}

	@Override
	public String key()
	{
		return this.fieldName;
	}
}
