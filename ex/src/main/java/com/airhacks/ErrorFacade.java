package com.airhacks;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Hijack
 */
@Stateless
public class ErrorFacade {
    
    @Inject
    ErrorService service;
    
    public void throwEx() {
        this.service.throwEx();
    }
            
    
}
