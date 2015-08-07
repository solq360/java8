package test.java8.example.stream.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private int age;

	public static Person of(String name, int age) {
		Person result = new Person();
		result.name = name;
		result.age = age;
		return result;
	}

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static List<Person> ofList() {
		List<Person> result = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			result.add(of("a" + i, i % 5));
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
