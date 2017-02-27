package src.main.java.solutions.exercises.ch3_streams;

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
		
		// TODO
		
		final IntStream ints6 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// TODO

	}
}