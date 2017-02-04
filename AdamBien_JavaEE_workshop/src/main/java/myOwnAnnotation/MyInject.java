package myOwnAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation are Metadata which can be put on Field, Classes, Methods
 * 
 * @author Hijack
 *
 */

//@Retention(RetentionPolicy.RUNTIME) Means that Annotation is in byte Code and available for Reflection. RetentionPolicy.Source means that Annotation is NOT in byte Code and NOT available for Reflection
//@Target(ElementType.FIELD) Hint for the Compiler. Put the Annotation just on a Field
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyInject {
	
	//without 'default' it must be later specified before compiletime 
	DayTime value() ;
	
	enum DayTime {
		MORNING, EVENING;
	}
	
	
	
}
