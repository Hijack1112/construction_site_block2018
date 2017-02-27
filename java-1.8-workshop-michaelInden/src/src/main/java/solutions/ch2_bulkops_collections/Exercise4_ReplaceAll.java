package src.main.java.solutions.ch2_bulkops_collections;

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
		final UnaryOperator<String> specialHighlighter = str -> {
			if (str.startsWith("M"))
			{
				return ">>" + str.toUpperCase() + "<<";
			}
			return str;
		};
		System.out.println(replaceAll_Internal_Iteration(names2, specialHighlighter));
		
		final List<String> names3 = createNamesList();
		final UnaryOperator<String> reverse = str -> {
			if (str.contains("i"))
			{				
				return new StringBuilder(str).reverse().toString();
			}
			return str;
		};
		System.out.println(replaceAll_Internal_Iteration(names3, reverse));
	}

	private static List<String> replaceAll_Internal_Iteration(final List<String> names, final UnaryOperator<String> operator) 
	{
		names.replaceAll(operator);		
		return names;		
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
