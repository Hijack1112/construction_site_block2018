package src.main.java.solutions.exercises.ch4_date_and_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise5_TemporalAdjusters 
{
	public static void main(final String[] args) 
	{
		final LocalDate christmasEve = LocalDate.of(2013, 12, 24);
		System.out.println(DayOfWeek.from(christmasEve));

		// a)
		// TODO
		
		// b)
		final LocalDate midOfMarch = LocalDate.of(2014, 3, 15);
		// TODO

//		System.out.println(firstSunday);
//		System.out.println(lastSunday);
//		System.out.println(lastFriday);
		
		// c)
		// TODO
	}
}
