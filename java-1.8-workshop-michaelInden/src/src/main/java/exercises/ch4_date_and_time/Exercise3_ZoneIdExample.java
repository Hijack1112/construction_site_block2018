package src.main.java.exercises.ch4_date_and_time;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise3_ZoneIdExample
{
    public static void main(final String[] args) 
    {
    	final Set<String> allZones = ZoneId.getAvailableZoneIds();
    	// TODO
    	
    	final List<String> threeFromEurope = new ArrayList<>(); // TODO
    
    	System.out.println("\nDesired timezones:");
    	threeFromEurope.forEach(System.out::println);
    }
}

