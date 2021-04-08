package ru.example.homework;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String name;
    private final int ID;
    private final int age;

    public Person(String name, int id, int age) {
        this.name = name;
        this.ID = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return ID == person.ID && age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID, age);
    }

    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getID)
                .thenComparing(Person::getName)
                .thenComparing(Person::getAge)
                .compare(this, o);
    }
}
