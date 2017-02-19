package com.darktower.worldpresenter.business.timezones.entity;

import java.time.ZoneId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hijack
 */
//@Entity
@XmlRootElement
//No need for Getters and Setters!
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {

//    @Id
//    @GeneratedValue
    private int id;

    private Continent continent;

    private String name;

    private ZoneId zoneId;

    public Country() {
    }

    public Country(Continent continent, String name) {
        this.continent = continent;
        this.name = name;
    }

}
