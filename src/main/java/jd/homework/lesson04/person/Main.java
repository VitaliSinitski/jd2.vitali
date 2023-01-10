package jd.homework.lesson04.person;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    Person person;

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        Person.peopleGenerator(personList);

        System.out.println("The total amount of people has been generated: " + personList.size());

        Person.removeIfOlder(personList);                               // We are removing Persons who are over 21 years old

//        personList.forEach(System.out::println);
        System.out.println("The amount of people who are younger than 21 years old: " + personList.size());

        // Sorting by SurName with custom Comparator
        Comparator<Person> compareBySurname = Comparator.comparing(Person::getSurname).thenComparing(Person::getName);
        personList.sort(compareBySurname);
        System.out.println("Comparator sorts by SurName: ");
        personList.forEach(System.out::println);

        // Sorting by Name with custom Comparator
        Comparator<Person> compareByName = Comparator.comparing(Person::getName).thenComparing(Person::getSurname);
        personList.sort(compareByName);
        System.out.println("Comparator sorts by Name: ");
        personList.forEach(System.out::println);

        // Removing Duplicates
        Person.removingDuplicates(personList);
        System.out.println("Were removed identical persons: ");
        personList.forEach(System.out::println);

        Path path = Path.of("src/main/resources", "person.txt");             // Creating object of class Path

        SerializationPerson.serializeListOfPersons(path, personList);     // Serialization List of Persons
        System.out.println("We have serialized list of Person");

        List<Person> newPersonList = new ArrayList<>();                     // Creating a new List for deserialized Persons

        // Deserialization List of Persons
        System.out.println("It is deserialized newPersonList: ");
        SerializationPerson.deserializeListOfPersons(path, newPersonList);

        newPersonList.forEach(System.out::println);
        System.out.println(newPersonList.size());

        System.out.println("It is stream:::::::");
//        List<Person> newListOfPersonsStream = new ArrayList<>();
//        SerializationPerson.deserializeListOfPersonsWithStream(path, newListOfPersonsStream);
//        newListOfPersonsStream.forEach(System.out::println);

//        Stream.of()
        List<String> personStringList = newPersonList.stream()
                .map(person1 -> person1.getName() + " " + person1.getSurname())
//                .map(Person::toString)
//                .forEach(System.out::println);
                .toList();

        personStringList.forEach(System.out::println );

    }


}
