package com.airhacks.di.presentation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;


/**
 * Own builded stereotype for better explanation of @Model in Index.java, which has also Stereotype annotation.
 * Application Server expands the annotation Presenter and replaces it with @RequestScoped and @Named
 * 
 * Presenter lives only in 1 Request
 * 
 * @author Hijack
 *
 */
@RequestScoped
@Named
@Target(ElementType.TYPE)
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
public @interface Presenter {

}
