package src.main.java.solutions.ch5_misc;

import java.util.ArrayList;
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
public class Excercise1_Comparator 
{
	public static void main(final String[] args) 
	{	
		final List<String> names = createNamesList();
		
		final Comparator<String> byLength = new Comparator<String>() 
		{
			@Override
			public int compare(final String str1, final String str2) 
			{				
				return Integer.compare(str1.length(), str2.length());
			}			
		};
		
		Collections.sort(names, byLength);
		System.out.println(names);
		
		// Using JDK 8
		final List<String> names2 = createNamesList();
		final Comparator<String> byLength2 = (str1, str2) -> Integer.compare(str1.length(), str2.length());
		Collections.sort(names2, byLength2);
		System.out.println(names2);
		
		// Combination of Comparators
		final Comparator<String> byLengthThenNatural = byLength2.thenComparing(Comparator.naturalOrder());
		Collections.sort(names2, byLengthThenNatural);
		System.out.println(names2);
				
		final Comparator<String> byLengthReversedThenNatural = byLength2.reversed().thenComparing(Comparator.naturalOrder());
		Collections.sort(names2, byLengthReversedThenNatural);
		System.out.println(names2);
	}

	private static List<String> createNamesList() 
	{
		final List<String> names = new ArrayList<>();
		names.add("Michael");
		names.add("Tim");
		names.add("Jörg");
		names.add("Flo");
		names.add("Andy");
		names.add("Clemens");
		return names;
	}
}
