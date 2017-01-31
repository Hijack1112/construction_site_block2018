package com.airhacks;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Hijack
 */
@ApplicationException(rollback = true)
public class InconsistentStoreException extends WebApplicationException {

    public InconsistentStoreException(String message) {
//        super(message, Status.BAD_REQUEST);
        super(message, Status.OK);
    }

    

}
