//
//  ClassDescriptor.h
//  ecologylabXML
//
//  Generated by CocoaTranslator on 12/14/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import <Foundation/Foundation.h>


/*!
	@class		Point
	@abstract	This class is generated by CocoaTranslator. Annotated as: 
				@simpl_inherit
	@discussion	missing java doc comments or could not find the source file.
*/
@interface Point
{
	/*!
		@var		x
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	int x;

	/*!
		@var		y
		@abstract	Annotated as : 
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	int y;

}

@property (nonatomic, readwrite) int x;
@property (nonatomic, readwrite) int y;

- (void) setXWithReference: (int *) p_x;
- (void) setYWithReference: (int *) p_y;

@end
