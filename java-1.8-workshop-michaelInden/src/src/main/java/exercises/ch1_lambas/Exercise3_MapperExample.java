package src.main.java.exercises.ch1_lambas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise3_MapperExample
{
    public static void main(final String[] args)
    {
        List<String> names = Arrays.asList("Tim", "Andi", "Michael");

        final Mapper<String, Integer> intMapper = String::length;
        System.out.println(intMapper.mapAll(names));

        final Mapper<String, String> stringMapper = str -> ">> " + str.toUpperCase() + " <<";
        final List<String> upperCaseNames = stringMapper.mapAll(names);
        System.out.println(upperCaseNames);
    }

    @FunctionalInterface
    public interface Mapper<S, T>
    {
        T map(S elem);

        default public List<T> mapAll(final List<S> sourceElements)
        {
        	// TODO
            return Collections.emptyList();
        }
    }
}
