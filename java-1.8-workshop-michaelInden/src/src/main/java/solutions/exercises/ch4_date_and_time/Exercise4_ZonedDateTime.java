package src.main.java.solutions.exercises.ch4_date_and_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise4_ZonedDateTime 
{
	public static void main(final String[] args) 
	{
		final LocalDate departureDate = LocalDate.of(2014, 7,7);
		final LocalTime departureTime = LocalTime.of(14, 30);
		final ZoneId zoneEurope = ZoneId.of("Europe/Zurich");
		final ZonedDateTime departure = ZonedDateTime.of(departureDate, departureTime, zoneEurope);

		// TODO
		
//		System.out.println(arrival1);
//		System.out.println(arrival2);
	}
}