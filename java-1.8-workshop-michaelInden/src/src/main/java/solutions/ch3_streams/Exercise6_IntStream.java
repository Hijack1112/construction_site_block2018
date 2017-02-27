package src.main.java.solutions.ch3_streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise6_IntStream 
{
	public static void main(final String[] args) 
	{
		final IntStream ints1 = IntStream.of(1,2,3,4,5,6,7,8,9,10);
		final IntStream ints2 = IntStream.range(0, 11);
		final IntStream ints3 = IntStream.rangeClosed(0, 10);
		final IntStream ints4 = IntStream.of(1,2,3,4,5,6,7,8,9,10);
		final IntStream ints5 = IntStream.of(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("min:     " + ints1.min());
		System.out.println("max:     " + ints2.max());
		System.out.println("sum:     " + ints3.sum());
		System.out.println("count:   " + ints4.count());
		System.out.println("average: " + ints5.average());
		
		final IntStream ints6 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final IntSummaryStatistics stats = ints6.collect(IntSummaryStatistics::new, IntSummaryStatistics::accept,
                                                         IntSummaryStatistics::combine);
        System.out.println(stats);
	}
}