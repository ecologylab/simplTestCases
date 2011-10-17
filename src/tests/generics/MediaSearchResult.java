package tests.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class MediaSearchResult<M> extends SearchResult 
{
	M media;
	
	public static void main(String args[])
	{
		Class<?> test = MediaSearchResult.class;
		TypeVariable[] typeParameters = test.getTypeParameters();
		
		for(TypeVariable t : typeParameters)
		{
			Type[] te = t.getBounds();
			Class<?> c = t.getClass();
			System.out.println(t);
		}
	}
}
