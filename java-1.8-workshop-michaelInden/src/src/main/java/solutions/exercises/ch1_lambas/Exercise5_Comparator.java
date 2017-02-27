package src.main.java.solutions.exercises.ch1_lambas;

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
public class Exercise5_Comparator {

	public static void main(String[] args) {

		final List<String> names = Arrays.asList("Josef", "JÖrg", "Jürgen");
		
    	final Comparator<String> byLength = new Comparator<String>() 
    	{
	 		@Override
			public int compare(final String str1, final String str2) 
		 	{
		     	return Integer.compare(str1.length(), str2.length());
		 	}
    	};

    	final Comparator<String> caseInsensitiveV1 = new Comparator<String>() 
    	{
	 		@Override
			public int compare(final String str1, final String str2) 
		 	{
		     	return str1.compareToIgnoreCase(str2);
		 	}
    	};

    	Collections.sort(names, byLength);
    	System.out.println(names);
    	
    	Collections.sort(names, caseInsensitiveV1);
    	System.out.println(names);

    	// JDK 8
    	final Comparator<String> byLengthJDK8 = null; 	// TODO
    	final Comparator<String> caseInsensitiveJDK8 = null; 	// TODO

    	// TODO
	}
}
