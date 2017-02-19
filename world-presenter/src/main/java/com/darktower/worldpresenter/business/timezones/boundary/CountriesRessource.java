package com.darktower.worldpresenter.business.timezones.boundary;

import com.darktower.worldpresenter.business.timezones.entity.Continent;
import com.darktower.worldpresenter.business.timezones.entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Hijack
 */
@Stateless
@Path("countries")
public class CountriesRessource {

    @GET
    public List<Country> getAll() {
        List<Country> listCountries = new ArrayList<>();
        listCountries.add(find(42));
        return listCountries;
    }

    @GET
    @Path("{id}")
    public Country find(@PathParam("id") int id) {
        Country country = new Country(Continent.EUROPE, "Deutschland with Id " + id);
        return country;
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        System.out.println("delete id = " + id);
    }
    
    @POST
    public void save(Country country) {
        System.out.println("save country = " + country);
    }
    
    
    
    
    

}
