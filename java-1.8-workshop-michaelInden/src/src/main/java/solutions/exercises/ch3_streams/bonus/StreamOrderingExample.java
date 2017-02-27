package src.main.java.solutions.exercises.ch3_streams.bonus;

import java.util.stream.Stream;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 * 
 * Angelehnt an http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class StreamOrderingExample 
{
	public static void main(final String[] args) 
	{
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		// TODO
		       forEach(name -> System.out.println("forEach: " + name));

		// 5a
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		// TODO
	           forEach(name -> System.out.println("forEach: " + name));

		// 5b 
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		// TODO
	       forEach(name -> System.out.println("forEach: " + name));

		// 5c 
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		// TODO
		       forEach(name -> System.out.println("forEach: " + name));

		// Tipp: Optimierung durch Reodering der Operationen: filter zuerst, dann sort oder map
		// 5c 
		Stream.of("Andi", "Barbara", "Carsten", "Marius", "Merten", "Micha", "Tim").
		// TODO
		       forEach(name -> System.out.println("forEach: " + name));
	}				
}
