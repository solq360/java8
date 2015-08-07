package test.java8.example.newcharacter.model;

import test.java8.example.stream.model.Person;

public interface PersonFactory<P extends Person> {
    P create(String name, int age);
}