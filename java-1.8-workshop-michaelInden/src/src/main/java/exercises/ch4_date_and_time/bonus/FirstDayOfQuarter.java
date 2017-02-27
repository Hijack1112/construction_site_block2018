package src.main.java.exercises.ch4_date_and_time.bonus;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class FirstDayOfQuarter implements TemporalAdjuster
{
    private static final Month[] startMonthOfQuarter = { Month.JANUARY, Month.APRIL, Month.JULY, Month.OCTOBER };

    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
    	// TODO
	    return LocalDate.now();
	}
}