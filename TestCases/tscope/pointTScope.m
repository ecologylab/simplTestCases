#import "pointTScope.h"

static SimplTypesScope *simplTypesScope;

@implementation pointTScope

+ (SimplTypesScope *) simplTypesScope
{	
	[Point class];

	if (simplTypesScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"pointTScope.xml"];
		simplTypesScope = [[SimplTypesScope alloc] initWithXMLFilePath: path];
	}
	return simplTypesScope;
}

@end

