package com.darktower.worldpresenter.business.timezones.boundary;

import com.darktower.worldpresenter.business.timezones.entity.Continent;
import com.darktower.worldpresenter.business.timezones.entity.Country;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Hijack
 */
@Stateless
public class CountryManager {

    @PersistenceContext
    EntityManager em;

    public Country save(Country country) {
        return this.em.merge(country);
    }

    public Country find(int id) {
        return this.em.find(Country.class, id);
    }

    public List<Country> getAll() {
//        List<Country> listCountries = new ArrayList<>();
//        listCountries.add(find(42));
//        return listCountries;
        return this.em.createNamedQuery(Country.findAll).getResultList();
    }

    public void delete(int id) {
        Country reference = this.em.getReference(Country.class, id);
        System.out.println("id= " + id);
        this.em.remove(reference);
    }

}
