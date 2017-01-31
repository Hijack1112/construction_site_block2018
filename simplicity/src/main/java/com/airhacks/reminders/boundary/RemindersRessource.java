package com.airhacks.reminders.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author Hijack
 */
@Stateless
@Path("reminders")
public class RemindersRessource {
    
    @Inject
    RemindersManager rm;
}
