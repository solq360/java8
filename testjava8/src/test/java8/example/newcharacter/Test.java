package test.java8.example.newcharacter;

import test.java8.example.newcharacter.model.TestCharacter;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import test.java8.example.newcharacter.model.Converter;
import test.java8.example.newcharacter.model.PersonFactory;
import test.java8.example.stream.model.Person;

public class Test {

	//http://www.jb51.net/article/48304.htm
	public static void main(String[] args) {
		TestCharacter c = new TestCharacter();
		c.test();

		/////////////////////////////// 接口绑定实例方法
		/////////////////////////////// ///////////////////////////////////////////

		// 将 Converter 绑定 Integer::valueOf 方法
		Converter<String, Integer> bindFn1 = Integer::valueOf;
		Integer r1 = bindFn1.convert("123");

		Converter<Integer, Integer> bindFn2 = Integer::valueOf;
		Integer r2 = bindFn2.convert(123);

		System.out.println(r1);
		System.out.println(r2);
		// 静态工厂
		PersonFactory<Person> personFactory = Person::new;
		Person testFactory = personFactory.create("a", 15);
		System.out.println(testFactory.getAge());

		// Supplier
		Supplier<Person> personSupper = Person::new;
		System.out.println(personSupper.get().getAge());

		// 代理调用
		Consumer<Person> call = (p) -> System.out.println("Hello, " + p.getAge());
		call.accept(new Person("Luke", 111));
		Function<String,Integer> call1= Integer::valueOf;
		System.out.println(call1.apply("55555555"));
		System.out.println("before : "+call1.andThen((v)->{
			System.out.println(v);
			return v;
		}).apply("1111"));

 	}
}
