//
//  Point.m
//  ecologylabXML
//
//  Generated by CocoaTranslator on 11/03/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import "Point.h"

@implementation Point

@synthesize x;
@synthesize y;
- (void) dealloc {
	[super dealloc];
}

- (void) setXWithReference: (int *) p_x {
	x = *p_x;
}

- (void) setYWithReference: (int *) p_y {
	y = *p_y;
}



@end

