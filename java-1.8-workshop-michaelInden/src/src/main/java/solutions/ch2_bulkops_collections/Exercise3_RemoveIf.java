package src.main.java.solutions.ch2_bulkops_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise3_RemoveIf
{
	public static void main(String[] args)
    {
		final List<String> names = removeIf_External_Iteration(createNamesList());
	    System.out.println("JDK 7 removeIf: " + names);
        
        final List<String> namesJdk8 = createNamesList();
        namesJdk8.removeIf(currentName -> currentName.length() < 4);
        System.out.println("JDK 8 removeIf: " + namesJdk8);
    }
	
    private static List<String> removeIf_External_Iteration(final List<String> names)                                  
    {                                                                                         
        final Iterator<String> it = names.iterator();                                        
        while (it.hasNext())                                                                  
        {                                                                                       
            final String currentName = it.next();                                                   
            if (currentName.length() < 4)        
            {
               it.remove();
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
        names.add("Clemens");                                                               
        return names;                                                                        
    }
}