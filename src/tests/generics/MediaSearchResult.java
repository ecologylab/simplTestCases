package tests.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import ecologylab.serialization.ClassDescriptor;

public class MediaSearchResult<M extends Media> extends SearchResult 
{
	M media;
	
	public static void main(String args[])
	{
		Class<?> test = MediaSearchResult.class;
		ClassDescriptor c = ClassDescriptor.getClassDescriptor(test);
		System.out.println(c);
	}
}
