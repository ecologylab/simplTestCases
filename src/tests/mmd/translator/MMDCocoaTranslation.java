package tests.mmd.translator;

import tests.TestingUtils;
import ecologylab.semantics.metametadata.MetaMetadataTranslationScope;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;

public class MMDCocoaTranslation
{
	public static void main(String args[]) throws SIMPLTranslationException
	{
		SimplTypesScope mmdScope = MetaMetadataTranslationScope.get();
		TestingUtils.generateCocoaClasses(mmdScope);
	}
}
