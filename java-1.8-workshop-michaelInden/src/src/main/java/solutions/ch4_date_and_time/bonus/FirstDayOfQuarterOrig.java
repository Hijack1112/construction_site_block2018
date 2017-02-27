package src.main.java.solutions.ch4_date_and_time.bonus;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * basierend auf http://www.leveluplunch.com/java/examples/first-day-of-quarter-java8-adjuster/
 */
public class FirstDayOfQuarterOrig implements TemporalAdjuster
{
    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        int currentQuarter = YearMonth.from(temporal).get(IsoFields.QUARTER_OF_YEAR);

        if (currentQuarter == 1)
        {
            return LocalDate.from(temporal).with(TemporalAdjusters.firstDayOfYear());
        }
        else if (currentQuarter == 2)
        {
            return LocalDate.from(temporal).withMonth(Month.APRIL.getValue()).with(firstDayOfMonth());
        }
        else if (currentQuarter == 3)
        {
            return LocalDate.from(temporal).withMonth(Month.JULY.getValue()).with(firstDayOfMonth());
        }
        else
        {
            return LocalDate.from(temporal).withMonth(Month.OCTOBER.getValue()).with(firstDayOfMonth());
        }
    }
}