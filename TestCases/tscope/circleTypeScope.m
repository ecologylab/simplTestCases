#import "circleTypeScope.h"

static SimplTypesScope *simplTypesScope;

@implementation circleTypeScope

+ (SimplTypesScope *) simplTypesScope
{	
	[ClassDescriptor class];
	[ClassDescriptor class];
	[ClassDescriptor class];

	if (simplTypesScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"circleTypeScope.xml"];
		simplTypesScope = [[SimplTypesScope alloc] initWithXMLFilePath: path];
	}
	return simplTypesScope;
}

@end

