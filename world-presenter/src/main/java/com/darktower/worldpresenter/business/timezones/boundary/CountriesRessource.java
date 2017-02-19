package com.darktower.worldpresenter.business.timezones.boundary;

import com.darktower.worldpresenter.business.timezones.entity.Continent;
import com.darktower.worldpresenter.business.timezones.entity.Country;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Hijack
 */
@Stateless
@Path("countries")
public class CountriesRessource {

    @Inject
    CountryManager cm;

    @POST
    public void save(Country country) {
        this.cm.save(country);
    }

    @GET
    @Path("{id}")
    public Country find(@PathParam("id") int id) {
        return this.cm.find(id);
    }

    @GET
    public List<Country> getAll() {
        return this.cm.getAll();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        this.cm.delete(id);
    }

}
