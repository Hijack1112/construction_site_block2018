package src.main.java.exercises.ch2_bulkops_collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise4_ReplaceAll 
{
	public static void main(String[] args) 
	{		
		final List<String> names1 = createNamesList();
		System.out.println(replaceAll_External_Iteration(names1));
		
		final List<String> names2 = createNamesList();
		// TODO
		System.out.println(names2);
		
		final List<String> names3 = createNamesList();
		// TODO
		System.out.println(names3);
	}
	
	private static List<String> replaceAll_External_Iteration(final List<String> names) 
	{
		final ListIterator<String> it = names.listIterator();
		while (it.hasNext())
		{
			final String currentName = it.next();
			if (currentName.startsWith("M"))
			{
				it.set(">>" + currentName.toUpperCase() + "<<");
			}
		}
		
		return names;
	}
	
	private static List<String> createNamesList() 
	{
		final List<String> names = new ArrayList<>();
		names.add("Michael");
		names.add("Tim");
		names.add("Flo");
		names.add("Merten");
		return names;
	}
}
