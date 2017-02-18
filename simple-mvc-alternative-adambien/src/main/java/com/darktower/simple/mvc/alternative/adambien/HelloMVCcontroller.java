package com.darktower.simple.mvc.alternative.adambien;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Hijack
 */
@Controller
@Path("hello")
public class HelloMVCcontroller {
    
    @Inject
    GreetingService gs;
    
    @Inject
    Models models;
    
    @GET
    public String welcomeView() {
        String helloMVC = gs.getHelloMVC();
        models.put("helloModel", new HelloModel(helloMVC));
        return "/helloMVC.jsp";
    }
}
