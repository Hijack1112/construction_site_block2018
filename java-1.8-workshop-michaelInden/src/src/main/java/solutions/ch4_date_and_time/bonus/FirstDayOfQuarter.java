package src.main.java.solutions.ch4_date_and_time.bonus;

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
 * Copyright 2016 by Michael Inden
 */
public class FirstDayOfQuarter implements TemporalAdjuster
{
    private static final Month[] startMonthOfQuarter = { Month.JANUARY, Month.APRIL, Month.JULY, Month.OCTOBER };

    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        final int currentQuarter = YearMonth.from(temporal).get(IsoFields.QUARTER_OF_YEAR);
        final Month startMonth = startMonthOfQuarter[currentQuarter - 1];

        return LocalDate.from(temporal).withMonth(startMonth.getValue()).with(firstDayOfMonth());
    }
}