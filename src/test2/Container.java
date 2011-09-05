package test2;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import ecologylab.serialization.ElementState;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.TranslationScope;
import ecologylab.serialization.annotations.simpl_collection;
import ecologylab.serialization.annotations.simpl_nowrap;
import ecologylab.serialization.annotations.simpl_scope;
import ecologylab.serialization.serializers.Format;

public class Container extends ElementState
{

	
	@simpl_nowrap
	@simpl_scope("itemScope1")
	@simpl_collection
	ArrayList<ItemBase>	itemCollection1;

//	@simpl_scope("itemScope2")
//	@simpl_collection
	ArrayList<ItemBase>	itemCollection2;

	public Container()
	{

	}

	public void populateContainer()
	{
		itemCollection1 = new ArrayList<ItemBase>();
		itemCollection2 = new ArrayList<ItemBase>();

		itemCollection1.add(new ItemOne(1, 1));
		itemCollection1.add(new ItemOne(1, 2));
		itemCollection1.add(new ItemOne(1, 3));
		itemCollection1.add(new ItemTwo("one", 1));
		itemCollection1.add(new ItemTwo("two", 2));
		itemCollection1.add(new ItemTwo("three", 3));

		itemCollection2.add(new ItemTwo("one", 1));
		itemCollection2.add(new ItemTwo("two", 2));
		itemCollection2.add(new ItemTwo("three", 3));
		itemCollection2.add(new ItemRandom("four", 4));
		itemCollection2.add(new ItemRandom("five", 5));
		itemCollection2.add(new ItemRandom("six", 6));
	}

	public static void main(String args[]) throws SIMPLTranslationException
	{

		Container c = new Container();
		c.populateContainer();

		TranslationScope itemTranslationScope = TranslationScope.get("itemScope1", ItemBase.class,
				ItemOne.class, ItemTwo.class);

		TranslationScope itemTranslationScope2 = TranslationScope.get("itemScope2", ItemBase.class,
				ItemRandom.class, ItemTwo.class);

		TranslationScope containerTranslationScope = TranslationScope.get("containerScope",
				Container.class, ItemBase.class, ItemOne.class, ItemTwo.class, ItemRandom.class);

		testDeSerialization(c, containerTranslationScope, Format.JSON, false);

	}

	public static void testDeSerialization(ElementState test, TranslationScope translationScope,
			Format format, boolean setGraphSwitch) throws SIMPLTranslationException
	{
		System.out.println();

		if (setGraphSwitch)
		{
			TranslationScope.enableGraphSerialization();
		}

		final StringBuilder output = new StringBuilder();
		OutputStream outputStream = new OutputStream()
		{
			@Override
			public void write(int b) throws IOException
			{
				output.append((char) b);
			}
		};

		ElementState deserializedObject = null;

		test.serialize(outputStream, format);

		System.out.println("Initialized object serialized into " + format + " representation.");
		System.out.println();

		System.out.println(output);

		System.out.println();

		deserializedObject = (ElementState) translationScope.deserializeCharSequence(output, format);

		System.out.println("Deserilized object serialized into " + format + "  representation");
		System.out.println();
		deserializedObject.serialize(System.out, format);

		System.out.println();

	}
}
