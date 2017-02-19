package com.darktower.worldpresenter.business.timezones.boundary;

import com.darktower.worldpresenter.business.timezones.entity.Continent;
import com.darktower.worldpresenter.business.timezones.entity.Country;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Hijack
 */
@Stateless
@Path("countries")
public class CountriesRessource {

//    @Inject
//    CountryManager cm;
//    @Path("{id}")
//    public Country find(@PathParam("id") int id) {
//        return this.cm.findById(id);
//    }
//    @GET
//    public String hello() {
//        return "core initializied ...: " + System.currentTimeMillis();
//    }
    
    @GET
    public Country getCountry() {
        Country country = new Country(Continent.EUROPE, "Deutschland");
        return country;
    }

    
    
//    @GET
//    @Path("{id}")
//    public Country getCountry(@PathParam("id") int id) {
//        System.out.println("id: " + id);
//        Country country = new Country(Continent.EUROPE, "Deutschland");
//        return country;
//    }

}
