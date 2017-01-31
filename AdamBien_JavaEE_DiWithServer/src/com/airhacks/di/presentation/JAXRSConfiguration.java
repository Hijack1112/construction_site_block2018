package com.airhacks.di.presentation;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class JAXRSConfiguration extends Application{

	/**
	 * The fact that the client can send an "Accept header" (try under linux: ~ curl -H "Accept: application/json")
	 * and the Server is responding to this, this is called content negotiaton and is a feature of JAXRS
	 * 
	 */
	
}
