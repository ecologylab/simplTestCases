//
//  Circle.h
//  ecologylabXML
//
//  Generated by CocoaTranslator on 11/07/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import <Foundation/Foundation.h>
#import "Point.h"


/*!
	@class		Circle
	@abstract	This class is generated by CocoaTranslator. 
	@discussion	missing java doc comments or could not find the source file.
*/
@interface Circle
{
	/*!
		@var		radius
		@abstract	Annotated as : 
					@simpl_hints
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	int radius;

	/*!
		@var		center
		@abstract	Annotated as : 
					@simpl_composite
		@discussion	missing java doc comments or could not find the source file.
	*/
	Point *center;

}

@property (nonatomic, readwrite) int radius;
@property (nonatomic, readwrite, retain) Point *center;

- (void) setRadiusWithReference: (int *) p_radius;

@end

