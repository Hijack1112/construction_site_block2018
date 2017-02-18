package com.darktower.simple.mvc.adambien;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Hijack
 */
@Model
public class HelloModel {
    
    @Inject
    GreetingService gs;
    
    public String getMessage() {
        return gs.getHelloMVC();
    }
}
