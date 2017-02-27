package src.main.java.solutions.ch2_bulkops_collections;

import java.util.function.Predicate;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise1_Predicates {

	public static void main(String[] args) {
		
		// a)
		final Predicate<Integer> isEven = value -> value % 2 == 0;
		final Predicate<Integer> isZero = value -> value == 0;
		final Predicate<Integer> isPositive = value -> value > 0;
		
		System.out.println("isEven(44) " + isEven.test(44));
		System.out.println("isEven(47) " + isEven.test(47));
		System.out.println("isPositive(47) " + isPositive.test(47));
		
		// b)
		final Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
		final Predicate<Integer> isPositiveAndOdd = isPositive.and(isEven.negate());

		System.out.println("isPositiveAndEven(44) " + isPositiveAndEven.test(44));
		System.out.println("isPositiveAndEven(47) " + isPositiveAndEven.test(47));
		System.out.println("isPositiveAndOdd(44) " + isPositiveAndOdd.test(44));
		System.out.println("isPositiveAndOdd(47) " + isPositiveAndOdd.test(47));
		
		// c)
		final Predicate<String> isShortWord = str -> str.length() < 4;
		final Predicate<String> isLongWord = (final String word) -> { return word.length() > 15; };
		System.out.println("isShortWord(\"abc\") " + isShortWord.test("abc"));
		System.out.println("isShortWord(\"!short\") " + isShortWord.test("!short"));
		System.out.println("isLongWord(\"Lichsignalanlage\") " + isLongWord.test("Lichsignalanlage"));	
	}
}
