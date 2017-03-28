package src.main.java.training.introductionBulkOperationsOnCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import src.main.java.training.model.Person;

/**
 *
 * @author Hijack
 */
public class FilterMapReduce {

    /**
     * Task:
     *
     * Filter on city vienna, Extract age Attribut, Create a comma separated
     * list
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        doTaskWithJDK7();

        doTaskWithJDK8();
    }

    public static void doTaskWithJDK7() {
        // until JDK 1.7
        List<Person> persons = Person.createDemoData();

        List<Person> liveInCity = filterByCity(persons, "Vienna");
        List<Integer> ages = extractPersonAges(liveInCity);
        String resultJDK7 = joinStrings(ages, ", ");

        System.out.println("resultJDK7 = " + resultJDK7);
    }

    private static List<Person> filterByCity(List<Person> persons, String city) {
        List<Person> personsLivingInSpecificCity = new ArrayList<>();
        for (Person person : persons) {
            if (city.equals(person.getCity())) {
                personsLivingInSpecificCity.add(person);
            }
        }
        return personsLivingInSpecificCity;
    }

    private static List<Integer> extractPersonAges(List<Person> persons) {
        List<Integer> extractPersonAges = new ArrayList<>();
        for (Person person : persons) {
            extractPersonAges.add(person.getAge());
        }
        return extractPersonAges;
    }

    private static String joinStrings(List<Integer> ages, String delimiter) {

        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = ages.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }

    public static void doTaskWithJDK8() {
        // with JDK 1.8 :)
        List<Person> listOfPersons = Person.createDemoData();
        String resultJDK8 = listOfPersons.stream()
                .filter(person -> person.getCity().equals("Vienna"))
                .map(person -> "" + person.getAge())
                .collect(Collectors.joining(", "));
        System.out.println("resultJDK8 = " + resultJDK8);
    }
}
