package tests.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

import ecologylab.serialization.ClassDescriptor;
import ecologylab.serialization.GenericTypeVar;

public class MediaSearch<M extends Media, T extends MediaSearchResult<? extends Media>> extends Search<T>
{
	public static void main(String args[])
	{
		Class<?> test = MediaSearch.class;
		ClassDescriptor c = ClassDescriptor.getClassDescriptor(test);
		ArrayList<GenericTypeVar> vars = c.getGenericTypeVars();
		
		System.out.print("<");
		int i = 0;
		for (GenericTypeVar g : vars)
		{			
			if (i++ > 0 ) System.out.print(", ");					
			System.out.print(g);
		}
		System.out.print(">");
	}
}
