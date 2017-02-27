package src.main.java.solutions.ch1_lambas.bonus;

import java.util.function.UnaryOperator;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class SimpleRecursiveLambdaExample
{
    public static UnaryOperator<Integer> f;

    public static void main(String[] args)
    {
        f = i -> i == 0 ? 1 : i * f.apply(i - 1);
        System.out.println(f.apply(5));
    }
}