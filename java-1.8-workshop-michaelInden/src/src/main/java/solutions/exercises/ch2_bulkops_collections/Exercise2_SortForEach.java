package src.main.java.solutions.exercises.ch2_bulkops_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise2_SortForEach 
{
	public static void main(final String[] args) 
	{
		final List<String> names = Arrays.asList("Tim", "Peter", "Mike");
		
		final Comparator<String> naturalOrder = new Comparator<String>() 
		{
			@Override
			public int compare(final String str1, final String str2) 
			{
				return str1.compareTo(str2);
			}
		};

		Collections.sort(names, naturalOrder);
		for (final String name : names)
		{
			System.out.println(name);
		}
		
		// JDK 8
		final Comparator<String> naturalOrder1 = null; // TODO
		final Comparator<String> naturalOrder2 = null; // TODO
		
		// TODO
	}
}
