package src.main.java.solutions.ch4_date_and_time;

import java.time.LocalDate;
import java.time.Period;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise2_Period_Calculation 
{
	public static void main(final String[] args) 
	{
		final Period period1 = Period.of(1, 2, 14);
		System.out.println(period1);
		
		// b)
		final Period period2 = Period.ofYears(1).ofMonths(2).ofDays(14);
		System.out.println(period2);
		
		// c)
		final Period period3 = Period.ofYears(1).withMonths(2).withDays(14);
		System.out.println(period3);
		
		// d)
		final LocalDate startday = LocalDate.of(2013, 10, 10);
		startday.plus(period3);
		System.out.println(startday);
		final LocalDate added = startday.plus(period1);
		System.out.println(added);
	}
}
