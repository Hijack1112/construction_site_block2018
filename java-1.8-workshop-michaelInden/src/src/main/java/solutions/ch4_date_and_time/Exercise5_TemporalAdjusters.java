package src.main.java.solutions.ch4_date_and_time;

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
		final TemporalAdjuster firstDay = TemporalAdjusters.firstDayOfMonth();
		final LocalDate decemberFirst = christmasEve.with(firstDay);
		System.out.println(DayOfWeek.from(decemberFirst));
		final LocalDate decemberLast = christmasEve.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(DayOfWeek.from(decemberLast));
		
		// b)
		final LocalDate midOfMarch = LocalDate.of(2014, 3, 15);
		final TemporalAdjuster toFirstSunday = TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY);
		final TemporalAdjuster toLastSunday = TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY);
		final TemporalAdjuster toLastFriday = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);

		final LocalDate firstSunday = midOfMarch.with(toFirstSunday);
		final LocalDate lastSunday = midOfMarch.with(toLastSunday);
		final LocalDate lastFriday = midOfMarch.with(toLastFriday);

		System.out.println(firstSunday);
		System.out.println(lastSunday);
		System.out.println(lastFriday);
		
		// c)
		System.out.println(firstSunday.getDayOfMonth());
		System.out.println(lastSunday.getDayOfMonth());
		System.out.println(lastFriday.getDayOfMonth());
		System.out.println(lastFriday.getDayOfYear());
		
		// Variante
		System.out.println("Starting at: " + lastFriday);
		System.out.println(toFirstSunday.adjustInto(lastFriday));
		System.out.println(lastFriday.with(toFirstSunday));
	}
}
