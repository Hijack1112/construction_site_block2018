package src.main.java.training.introductionBulkOperationsOnCollections;

import src.main.java.training.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import src.main.java.training.model.Person.Gender;

/**
 *
 * @author Hijack
 */
public class PredicateExample {

    public static void main(String[] args) {

        List<Person> persons = Person.createDemoData();
        System.out.println("persons = " + persons);

        Predicate<Person> isFemale = person -> person.getGender() == Gender.FEMALE;
        Predicate<Person> isMale = isFemale.negate();
        Predicate<Person> over50 = person -> person.getAge() > 50;

        persons.removeIf(isMale.and(over50));
        persons.removeIf(person -> person.getName().trim().isEmpty());

        persons.forEach(person -> System.out.println(person));

    }

}
