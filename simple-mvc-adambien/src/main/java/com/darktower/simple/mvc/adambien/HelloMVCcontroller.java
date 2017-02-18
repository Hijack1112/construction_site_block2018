package com.darktower.simple.mvc.adambien;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Hijack
 */
@Controller
@Path("hello")
public class HelloMVCcontroller {
    
    @GET
    public String welcomeView() {
        return "/helloMVC.jsp";
    }
}
