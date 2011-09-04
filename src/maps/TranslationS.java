package maps;

import java.util.HashMap;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.annotations.simpl_map;
import ecologylab.serialization.annotations.simpl_nowrap;

public class TranslationS extends ElementState
{
	@simpl_nowrap
	@simpl_map("class_descriptor")
	public HashMap<String, ClassDes>	entriesByTag;
	
	public TranslationS()
	{
		entriesByTag = new HashMap<String, ClassDes>();
	}

}
