package src.main.java.solutions.ch3_streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise1_StreamTypicalSteps {

	public static void main(String[] args) 
	{
		final String[] namesArray = {"Tim", "Tom", "Andy", "Mike", "Merten"};
		
		// Create
		final Stream<String> namesStream = Arrays.stream(namesArray);

		// Intermediate
		final Stream<String> mapped = namesStream.map(str -> str.toUpperCase());
		final Stream<String> filtered = mapped.filter(str -> str.contains("T"));
		
		// Terminal
		filtered.forEach(str -> System.out.print(str + ", "));
		System.out.println();
	}
}
