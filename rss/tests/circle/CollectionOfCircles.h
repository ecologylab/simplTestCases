//
//  CollectionOfCircles.h
//  ecologylabXML
//
//  Generated by CocoaTranslator on 11/07/11.
//  Copyright 2011 Interface Ecology Lab. 
//

#import <Foundation/Foundation.h>


/*!
	@class		CollectionOfCircles
	@abstract	This class is generated by CocoaTranslator. 
	@discussion	missing java doc comments or could not find the source file.
*/
@interface CollectionOfCircles
{
	/*!
		@var		collectionOfCircles
		@abstract	Annotated as : 
					@simpl_collection
		@discussion	missing java doc comments or could not find the source file.
	*/
	NSMutableArray *collectionOfCircles;

	/*!
		@var		yo
		@abstract	Annotated as : 
					@simpl_hints
					@simpl_scalar
		@discussion	missing java doc comments or could not find the source file.
	*/
	int yo;

}

@property (nonatomic, readwrite, retain) NSMutableArray *collectionOfCircles;
@property (nonatomic, readwrite) int yo;

- (void) setYoWithReference: (int *) p_yo;

@end

