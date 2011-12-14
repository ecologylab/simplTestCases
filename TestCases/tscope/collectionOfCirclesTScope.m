#import "collectionOfCirclesTScope.h"

static SimplTypesScope *simplTypesScope;

@implementation collectionOfCirclesTScope

+ (SimplTypesScope *) simplTypesScope
{	
	[Point class];
	[CollectionOfCircles class];
	[Circle class];

	if (simplTypesScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"collectionOfCirclesTScope.xml"];
		simplTypesScope = [[SimplTypesScope alloc] initWithXMLFilePath: path];
	}
	return simplTypesScope;
}

@end

