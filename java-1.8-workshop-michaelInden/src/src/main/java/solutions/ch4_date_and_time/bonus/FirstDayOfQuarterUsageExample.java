package src.main.java.solutions.ch4_date_and_time.bonus;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class FirstDayOfQuarterUsageExample
{
    public static void main(final String[] args)
    {
        final LocalDate midOfMarch = LocalDate.of(2014, 3, 15);
        final LocalDate midOfJune = LocalDate.of(2014, 6, 15);
        final LocalDate midOfSep = LocalDate.of(2014, 9, 15);
        final LocalDate midOfNov = LocalDate.of(2014, 11, 15);
        
        final TemporalAdjuster toFirsstDay1 = new FirstDayOfQuarterOrig();
        final TemporalAdjuster toFirsstDay2 = new FirstDayOfQuarter();
        final TemporalAdjuster toFirsstDay3 = new FirstDayOfQuarterShort();
        
        final LocalDate[] dates = {midOfMarch, midOfJune, midOfSep, midOfNov};
        final TemporalAdjuster[] adjusters = {toFirsstDay1, toFirsstDay2, toFirsstDay3}; 
        
        for (final TemporalAdjuster adjuster : adjusters)
        {
            for (final LocalDate date : dates)
            {
                System.out.println(date.with(adjuster));            
            }
        }        
    }
}
