package com.airhacks.reminders.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hijack
 */
@Stateless
public class RemindersManager {
    
    @PersistenceContext
    EntityManager em;
}
