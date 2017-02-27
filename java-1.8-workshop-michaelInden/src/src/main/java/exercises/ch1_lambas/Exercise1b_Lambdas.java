package src.main.java.exercises.ch1_lambas;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise1b_Lambdas
{
    public interface LongBinaryOperator
    {
        long applyAsLong(final long left, final Long right);
    }
    
    public static void main(String[] args)
    {
         final LongBinaryOperator v1 = (long x, Long y) -> { return x + y; };                     
         final LongBinaryOperator v2 = (long x, Long y) -> { return x + y; };                 
//         final LongBinaryOperator v3 = (long x, new Long(y) -> x + y;                            
//         final LongBinaryOperator v4 = (long x, y) -> x + y;                                 
//         final LongBinaryOperator v5 = (x, y) -> x +s y;                                      
//         final LongBinaryOperator v6 = x, y -> x + y;  
    }
}