package src.main.java.solutions.ch4_date_and_time.bonus;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Stefan Ackermann, Michael Inden
 *
 * Copyright 2016 by Stefan Ackermann & Michael Inden
 */
public class FirstDayOfQuarterShort implements TemporalAdjuster
{
    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        return LocalDate.from(temporal).with(IsoFields.DAY_OF_QUARTER, 1);
    }
}