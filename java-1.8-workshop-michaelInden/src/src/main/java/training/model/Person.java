package src.main.java.training.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hijack
 */
public class Person {

    public enum Gender {
        MALE, FEMALE;
    }

    private String name;
    private int age;
    private Gender gender;
    private String city;

    public Person(String name, int age, Gender gender, String city) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAdult() {
        if (age >= 18) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nPerson{" + "name=" + name + ", age=" + age + ", gender=" + gender + ", city=" + city + '}';
    }

    public static List<Person> createDemoData() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 45, Gender.MALE, "Vienna"));
        persons.add(new Person("Tim", 23, Gender.MALE, "London"));
        persons.add(new Person("Sarah", 51, Gender.FEMALE, "Madrid"));
        persons.add(new Person("Maria", 33, Gender.FEMALE, "Vienna"));
        persons.add(new Person("Peter", 17, Gender.MALE, "Barcelona"));
        persons.add(new Person("Nina", 37, Gender.FEMALE, "Paris"));
        persons.add(new Person("Tom", 67, Gender.MALE, "Peking"));
        return persons;
    }

}
