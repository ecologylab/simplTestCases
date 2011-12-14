#import "circleTScope.h"

static SimplTypesScope *simplTypesScope;

@implementation circleTScope

+ (SimplTypesScope *) simplTypesScope
{	
	[Point class];
	[Circle class];

	if (simplTypesScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"circleTScope.xml"];
		simplTypesScope = [[SimplTypesScope alloc] initWithXMLFilePath: path];
	}
	return simplTypesScope;
}

@end

