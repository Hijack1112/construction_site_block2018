package src.main.java.solutions.exercises.ch3_streams.bonus;

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
     // TODO   
                        .forEach(name -> System.out.println("forEach: " + name));
    }
}