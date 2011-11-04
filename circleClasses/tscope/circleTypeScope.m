#import "circleTypeScope.h"

static TranslationScope *translationScope;

@implementation circleTypeScope

+ (TranslationScope *) translationScope
{	
	[Point class];
	[Circle class];
	[Point class];

	if (translationScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"circleTypeScope.xml"];
		translationScope = [[TranslationScope alloc] initWithXMLFilePath: path];
	}
	return translationScope;
}

@end

