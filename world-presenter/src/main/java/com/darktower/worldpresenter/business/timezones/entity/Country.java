package com.darktower.worldpresenter.business.timezones.entity;

import java.time.ZoneId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hijack
 */
@Entity
@XmlRootElement
//No need for Getters and Setters!
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = Country.findAll, query = "SELECT c FROM Country c")
public class Country {

    @Id
    @GeneratedValue
    private int id;

    public static final String PREFIX = "timezones.entity.Country";
    public static final String findAll = PREFIX + "findAll";

    private Continent continent;
    private String name;
    private ZoneId zoneId;

    public Country() {
    }

    public Country(Continent continent, String name) {
        this.continent = continent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
    
    
    

}
