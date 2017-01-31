package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Hijack
 */
@Path("messages")
public class MessagesResources {

    @GET
    public String message() {
        return "[Hello Docker!]";
    }
    
}
