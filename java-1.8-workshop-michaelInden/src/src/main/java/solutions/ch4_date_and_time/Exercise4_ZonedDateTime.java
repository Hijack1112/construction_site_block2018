package src.main.java.solutions.ch4_date_and_time;

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

		// Es gibt kein withMinutes(), wieso eigentlich nicht? API ist ansonsten sehr konsistent
		final Duration flightDuration = Duration.ofHours(11).plusMinutes(30);
		
		// Calculate Arrival time based on European and American Time
		final ZonedDateTime arrival1 = departure.plus(flightDuration);
		final ZoneId zoneAmerica = ZoneId.of("America/Los_Angeles");
		final ZonedDateTime arrival2 = arrival1.withZoneSameInstant(zoneAmerica);
		
		System.out.println(arrival1);
		System.out.println(arrival2);
	}
}