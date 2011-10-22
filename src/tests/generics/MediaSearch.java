package tests.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.GenericTypeVar;

public class MediaSearch<M extends Media, T extends MediaSearchResult<M>> extends Search<T>
{
	public static void main(String args[])
	{
		Class<?> test = MediaSearch.class;
		ClassDescriptor c = ClassDescriptor.getClassDescriptor(test);
		ArrayList<GenericTypeVar> vars = c.getGenricTypeVars();
		System.out.println(c);
	}
}
