#import "rss.h"

static SimplTypesScope *simplTypesScope;

@implementation rss

+ (SimplTypesScope *) simplTypesScope
{	
	[Item class];
	[Rss class];
	[Channel class];

	if (simplTypesScope == nil)
	{
		NSString *path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent: @"rss.xml"];
		simplTypesScope = [[SimplTypesScope alloc] initWithXMLFilePath: path];
	}
	return simplTypesScope;
}

@end

