//
//  Rss.m
//  ecologylabXML
//
//  Generated by CocoaTranslator on 11/03/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import "Rss.h"

@implementation Rss

@synthesize version;
@synthesize channel;
- (void) dealloc {
	[channel release];
	[super dealloc];
}

- (void) setVersionWithReference: (float *) p_version {
	version = *p_version;
}



@end

