package src.main.java.solutions.ch4_date_and_time;

import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    	final Predicate<String> inEuropes = name -> name.startsWith("Europe/S");
    	final Predicate<String> inAmericaL = name -> name.startsWith("America/L");
    	final Predicate<String> europeOrAmerica = inEuropes.or(inAmericaL);
    	
    	final List<String> threeFromEurope = allZones.stream().
    	                                              filter(europeOrAmerica).sorted().
    	                                              collect(Collectors.toList());
    
    	System.out.println("\nDesired timezones:");
    	threeFromEurope.forEach(System.out::println);
    }
}

