package src.main.java.solutions.exercises.ch4_date_and_time;

import java.time.LocalDate;
import java.time.Period;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise1_BirthdayCalulationExample
{
    public static void main(final String[] args)
    {
        final LocalDate now = LocalDate.now();                                              
        final LocalDate birthday = LocalDate.of(1971, 2, 7);          
        
        System.out.println("Using LocalDate.until()");
        // TODO
        System.out.println();
        System.out.println("Using Period.between()");
        // TODO
    }
}

