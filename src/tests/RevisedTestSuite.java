package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestSuite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.SimplTypesScope.GRAPH_SWITCH;
import ecologylab.serialization.TranslationContext;
import ecologylab.serialization.formatenums.Format;
import ecologylab.serialization.formatenums.StringFormat;

import tests.circle.Circle;

@RunWith(Parameterized.class)
public class RevisedTestSuite extends TestSuite{

	static ArrayList<SimplTestCase> simplTestCases = new ArrayList<SimplTestCase>();
	
	
	/***
	 * Function for loading in test cases...
	 */
	public static void populateTestCases()
	{
		simplTestCases.add(new Circle());
	}
	
	SimplTestCase simplTestCase;
	public RevisedTestSuite(Object[] param)
	{
		simplTestCase = (SimplTestCase)param[0];
	}
	
	@Parameters
    public static Collection<Object[]> getFiles() {
    	Collection<Object[]> params = new ArrayList<Object[]>();
    	System.out.println("Adding in the new thing");
    	populateTestCases();
    	for(SimplTestCase st:simplTestCases)
    	{
    		params.add(new Object [] {new Object [] {(st)}});
    	}
    	return params;
    }

    public static void serializeAndDeserialize(Object object, SimplTypesScope scope, Format format) throws SIMPLTranslationException
    {
    	SimplTypesScope.enableGraphSerialization();
    	
    	ByteArrayOutputStream serializedBytes = new ByteArrayOutputStream();
    	SimplTypesScope.serialize(object, serializedBytes, format);
    	
    	//StringBuilder serialized = SimplTypesScope.serialize(object, format);
	    //assertNotNull(serialized);
	    //assertTrue(serialized.length() > 0);
	    //String serializedString = serialized.toString();
	    //Object deserializedObject = scope.deserialize(serializedString, format);
    	assertNotNull(serializedBytes);
	    assertTrue(serializedBytes.size() > 0);
		Object deserializedObject = scope.deserialize(new ByteArrayInputStream(serializedBytes.toByteArray()), format);
	    assertNotNull(deserializedObject);
	    assertEquals(object.getClass(),deserializedObject.getClass());
    }
	
	@Test
	public void TestSerilaizationXML() throws SIMPLTranslationException
	{
		SimplTestObject sto = this.simplTestCase.getTestObject();
		serializeAndDeserialize(sto.instance,sto.deSlashSerializationScope,Format.XML);
	}
	@Test
	public void TestSerilaizationJSON() throws SIMPLTranslationException
	{
		SimplTestObject sto = this.simplTestCase.getTestObject();
		serializeAndDeserialize(sto.instance,sto.deSlashSerializationScope,Format.JSON);
	}
	@Test
	public void TestSerilaizationTLV() throws SIMPLTranslationException
	{
		SimplTestObject sto = this.simplTestCase.getTestObject();
		serializeAndDeserialize(sto.instance,sto.deSlashSerializationScope,Format.TLV);
	}
}
