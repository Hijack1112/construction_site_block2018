package src.main.java.training.introductionBulkOperationsOnCollections;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import src.main.java.training.model.Person;

/**
 *
 * @author Hijack
 */
public class Streams {

    public static void main(String[] args) {
        List<Person> persons = Person.createDemoData();
        System.out.println("persons = " + persons);
        System.out.println("---------------------");

        List<Person> adults = persons.stream().filter(Person::isAdult).collect(Collectors.toList());
        System.out.println("adults = " + adults);

        Stream<Integer> adultsAsStreamMapValue = persons.stream().map(Person::getAge).filter(age -> age < 18).peek(System.out::println);

        //java.lang.IllegalStateException
//        Stream<Integer> adultsAsStreamMapValue2 = adultsAsStreamMapValue.filter(age -> age < 18);
        
        
        long countAdults = adultsAsStreamMapValue.count();
        System.out.println("countAdults = " + countAdults);

        final Stream<Integer> integers = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> addition = integers.reduce((num1, num2) -> (num1 + num2));
        System.out.println("addition = " + addition);

    }

}
