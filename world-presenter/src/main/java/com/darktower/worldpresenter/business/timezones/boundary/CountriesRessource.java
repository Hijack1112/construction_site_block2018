package com.darktower.worldpresenter.business.timezones.boundary;

import com.darktower.worldpresenter.business.timezones.entity.Continent;
import com.darktower.worldpresenter.business.timezones.entity.Country;
import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
    public Response save(Country country,@Context UriInfo info) {
        Country saved = this.cm.save(country);
        int id = saved.getId();
        System.out.println("id = " + id);
        //for Junit test
        URI uri = info.getAbsolutePathBuilder().path("/" + id).build();
        return Response.created(uri).build();
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
