package src.main.java.solutions.ch3_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise3_GroupingBy {

	public static void main(final String[] args) 
	{
		final String[] namesArray = {"Tim", "Tom", "Andy", "Mike", "Merten"};
		final List<String> names = Arrays.asList(namesArray);

		// Create
		final Stream<String> streamFromList = names.stream();
		final Stream<String> streamFromValues = Stream.of(namesArray);
		final Stream<String> streamFromValues2 = Stream.of(namesArray);
		
		// a)
		final Map<Character, List<String>> grouped = streamFromList.collect(Collectors.groupingBy(str -> str.charAt(0)));
		System.out.println(grouped);

		// b)
		final Map<Boolean, List<String>> partioned = streamFromValues.collect(Collectors.partitioningBy(str -> str.length() <= 3));
		System.out.println(partioned);
		
		// c)
		final Map<Character, Long> groupedAndCounted = streamFromValues2.collect(Collectors.groupingBy(str -> str.charAt(0), Collectors.counting()));
		System.out.println(groupedAndCounted);
	}
}
