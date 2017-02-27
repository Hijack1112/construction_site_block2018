package src.main.java.solutions.exercises.ch4_date_and_time.bonus;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class NthWeekdayAdjuster implements TemporalAdjuster
{
    private final DayOfWeek dayToAdjust;
    private final int       count;

    public NthWeekdayAdjuster(final DayOfWeek dayToAdjust, final int count)
    {
        this.dayToAdjust = dayToAdjust;
        this.count = count;
    }

    public Temporal adjustInto(final Temporal input)
    {
       	// TODO
        return LocalDate.now();
    }
}
