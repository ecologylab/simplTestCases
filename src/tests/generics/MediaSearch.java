package tests.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import ecologylab.serialization.ClassDescriptor;

public class MediaSearch<M extends Media, T extends MediaSearchResult<M>> extends Search<T>
{
	public static void main(String args[])
	{
		Class<?> test = MediaSearch.class;
		ClassDescriptor c = ClassDescriptor.getClassDescriptor(test);
		System.out.println(c);
	}
}
