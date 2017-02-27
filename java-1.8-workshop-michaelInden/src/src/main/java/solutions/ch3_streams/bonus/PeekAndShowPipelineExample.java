package src.main.java.solutions.ch3_streams.bonus;

import java.util.stream.Stream;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class PeekAndShowPipelineExample
{
    public static void main(final String[] args)
    {
        Stream.of("Andi", "Barbara", "Tom", "Carsten", "Mike", "Marius", "Micha", "Tim")
                        .peek(str -> System.out.println("taking element: " + str))        
                        .filter(str -> str.length() > 4)
                        .peek(str -> System.out.println("after filter > 4: " + str))        
                        .map(str -> str.toUpperCase())      
                        .peek(str -> System.out.println("after map: " + str))   
                        .filter(str -> str.startsWith("M"))
                        .peek(str -> System.out.println("after filter 'M': " + str))        
                        .forEach(name -> System.out.println("forEach: " + name));
    }
}