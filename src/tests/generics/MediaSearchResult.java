package tests.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.GenericTypeVar;

public class MediaSearchResult<M extends Media> extends SearchResult 
{
	M media;
	
	public static void main(String args[])
	{
		Class<?> test = MediaSearchResult.class;
		ClassDescriptor c = ClassDescriptor.getClassDescriptor(test);
		ArrayList<GenericTypeVar> vars = c.getGenricTypeVars();
		System.out.println(c);
	}
}
