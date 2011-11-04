#import "rss.h"

static TranslationScope *translationScope;

@implementation rss

+ (TranslationScope *) translationScope
{	
	[Point class];
	[Person class];
	[Circle class];
	[Point class];
	[CollectionOfCircles class];
	[Student class];
	[Person class];
	[Circle class];
	[Point class];
	[Rss class];
	[Channel class];
	[Item class];
	[Circle class];
	[Point class];
	[Faculty class];
	[Person class];

	if (translationScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"rss.xml"];
		translationScope = [[TranslationScope alloc] initWithXMLFilePath: path];
	}
	return translationScope;
}

@end

