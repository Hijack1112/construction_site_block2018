package src.main.java.solutions.ch1_lambas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Beispielprogramm im Rahmen des Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2016 by Michael Inden
 */
public class Exercise5_Comparator
{
    public static void main(String[] args)
    {
        final Map<String, String> map = new HashMap<>();
        map.put(null, "NULL");
        System.out.println(map.get(null));
        
        final List<String> names = Arrays.asList("Josef", "JÖrg", "Jürgen");

        final Comparator<String> byLength = new Comparator<String>()
        {
            @Override
            public int compare(final String str1, final String str2)
            {
                return Integer.compare(str1.length(), str2.length());
            }
        };

        final Comparator<String> caseInsensitiveV1 = new Comparator<String>()
        {
            @Override
            public int compare(final String str1, final String str2)
            {
                return str1.compareToIgnoreCase(str2);
            }
        };

        Collections.sort(names, byLength);
        System.out.println(names);

        Collections.sort(names, caseInsensitiveV1);
        System.out.println(names);

        // JDK 8
        final Comparator<String> byLengthJDK8 = (str1, str2) -> Integer.compare(str1.length(), str2.length());
        final Comparator<String> caseInsensitiveJDK8 = (str1, str2) -> str1.compareToIgnoreCase(str2);

        names.sort(byLengthJDK8);
        System.out.println(names);

        names.sort(caseInsensitiveJDK8);
        System.out.println(names);
    }
}
