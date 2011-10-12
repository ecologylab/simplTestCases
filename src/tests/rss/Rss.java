// RssState.java

package tests.rss;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import tests.TestCase;
import tests.TestingUtils;
import ecologylab.net.ParsedURL;
import ecologylab.serialization.SIMPLTranslationException;
import ecologylab.serialization.Format;
import ecologylab.serialization.SimplTypesScope;
import ecologylab.serialization.annotations.simpl_composite;
import ecologylab.serialization.annotations.simpl_scalar;

public class Rss implements TestCase
{
	@simpl_scalar
	float		version;

	@simpl_composite
	Channel	channel;

	public Rss()
	{
	}

	public Channel getChannel()
	{
		return channel;
	}

	@Override
	public void runTest() throws SIMPLTranslationException
	{
		SimplTypesScope translationScope = SimplTypesScope.get("rss", Rss.class, Channel.class,
				Item.class);

		Rss rssState = new Rss();
		Channel channel = new Channel();
		Item item1 = new Item();
		Item item2 = new Item();

		ArrayList<String> categorySet = new ArrayList<String>();

		rssState.version = 1.0f;

		channel.title = "testTitle";
		channel.description = "testDescription";
		
		try
		{
			channel.link = new ParsedURL(new URL("http://www.google.com"));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

		categorySet.add("category1");
		categorySet.add("category2");

		item1.title = "testItem1";
		item1.description = "testItem1Description";
		item1.categorySet = categorySet;

		item2.title = "testItem2";
		item2.description = "testItem2Description";

		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);

		channel.items = items;
		rssState.channel = channel;

		TestingUtils.test(rssState, translationScope, Format.XML);
		TestingUtils.test(rssState, translationScope, Format.JSON);
		TestingUtils.test(rssState, translationScope, Format.TLV);

	}
}
