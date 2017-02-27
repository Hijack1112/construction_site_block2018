package src.main.java.solutions.ch3_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise2_Joining {

	public static void main(final String[] args) 
	{
		final String[] namesArray = {"Tim", "Tom", "Andy", "Mike", "Merten"};
		final List<String> names = Arrays.asList(namesArray);

		System.out.println("Lambda");
		names.forEach(str -> System.out.print(str + ", "));

		// Collectors.joining
		System.out.println("\nJoining");
		final String joined = names.stream().collect(Collectors.joining(", "));
		System.out.println(joined);
	}
}
