package src.main.java.solutions.exercises.ch1_lambas.bonus;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class RecursiveLambda {

	// Ausgangsbasis
	public static final long factorialRec(final int n)
	{
		if (n < 0)
			throw new IllegalArgumentException("n must be positive");
		
		if (n==0)
			return 1;
		
		return n * factorialRec(n-1);
	}
	
	public static void main(String[] args) {
	
		final IntFunction<Long> factorial1 = RecursiveLambda::factorialRec;
		System.out.println(factorial1.apply(5));

		// TODO
	}
}
