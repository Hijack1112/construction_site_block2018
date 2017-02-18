package com.darktower.simple.mvc.adambien;

import javax.ejb.Stateless;

/**
 *
 * @author Hijack
 */
@Stateless
public class GreetingService {
    
    public String getHelloMVC() {
        return "Hello MVC Example " + System.currentTimeMillis();
    }

}
