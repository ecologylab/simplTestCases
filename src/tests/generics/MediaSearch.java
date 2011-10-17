package tests.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class MediaSearch<M extends Media, T extends MediaSearchResult<M>> extends Search<T>
{
	public static void main(String args[])
	{
		Class<?> test = MediaSearch.class;
		TypeVariable[] typeParameters = test.getTypeParameters();
		
		for(TypeVariable t : typeParameters)
		{
			Type[] te = t.getBounds();
			Class<?> c = t.getClass();
			System.out.println(t);
		}
	}
}
