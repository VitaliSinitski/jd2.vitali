package jd.homework.lesson04.person;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1059337677584733230L;
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void peopleGenerator(List<Person> personList) {
        Random random = new Random();
        String[] names = new String[]{"Liam", "Olivia", "Emma", "Oliver", "Charlotte", "Amelia", "James", "William", "Sophia", "Benjamin", "Isabella", "Lucas", "Mia", "Henry", "Evelyn"};
        String[] surnames = new String[]{"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "White", "Harris", "Clark"};
        for (int i = 0; i < 100; i++) {
            personList.add(new Person(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], random.nextInt(15, 31)));
        }
    }

    public static void removeIfOlder(List<Person> personList) {
        personList.removeIf(person -> person.getAge() >= 21);
    }

    public static void compareByName(List<Person> personList) {
        Comparator<Person> compareByName = Comparator.comparing(Person::getName);
    }


    public static void removingDuplicates(List<Person> personList) {
        Set<Person> personSet = new HashSet<>(personList.size());
        personList.removeIf(person -> !personSet.add(person));
    }


    @Override
    public String toString() {
        return name + " : " + surname + " : " + age;
    }
}