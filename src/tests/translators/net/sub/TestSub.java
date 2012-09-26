package tests.translators.net.sub;

import tests.translators.net.TestBase;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_inherit;

@simpl_inherit
public class TestSub extends TestBase
{

	@simpl_composite
	private TestBase composite1;
	
}
