package com.airhacks;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Hijack
 */
@Path("ex")
public class ExceptionsResource {
    
    @Inject
    ErrorFacade facade;
    
    @GET
    public String message() {
        facade.throwEx();
        return "42";
    }
}
