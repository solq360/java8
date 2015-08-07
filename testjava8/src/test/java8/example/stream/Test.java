package test.java8.example.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import test.java8.example.TimeHelper;
import test.java8.example.stream.model.Person;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		List<Person> list = Person.ofList();
		TimeHelper.start();
		Stream<Person> stream = list.stream().filter(e -> {
			return e.getAge() > 2;
		}).filter(e -> {
			return e.getAge() > 3;
		});

		System.out.println("Stream count : " + stream.count());
		TimeHelper.end();

		Thread.sleep(5000L);

		TimeHelper.start();
		Stream<Person> stream2 = list.stream().filter(e -> {
			return e.getAge() > 1;
		}).filter(e -> {
			return e.getAge() > 2;
		});

		System.out.println("Stream2 count : " + stream2.count());
		TimeHelper.end();
	}

	static class Test2 {
		public static void main(String[] args) {
			List<Person> list = Person.ofList();
			TimeHelper.start();
			int count = 0;
			for (Person e : list) {
				if (!(e.getAge() > 2)) {
					continue;
				}
				if (!(e.getAge() > 3)) {
					continue;
				}
				count++;
			}
			System.out.println("count : " + count);
			TimeHelper.end();
		}
	}

	static class Test3 {
		public static void main(String[] args) {
			List<Person> list = Person.ofList();
			TimeHelper.start();
			List<Person> result = new ArrayList<>();
			for (Person e : list) {
				if (!(e.getAge() > 2)) {
					continue;
				}
				if (!(e.getAge() > 3)) {
					continue;
				}
				result.add(e);
			}
			System.out.println("count : " + result.size());
			TimeHelper.end();
		}
	}

	/***
	 * ����ͳ��API <br>
	 * С��:<br>
	 * 1.�߼�����Ӧ��{} ������  ��д{} Ĭ��  + return <br>
	 * 2.���ط��������������������<br>
	 * 3.��д���һ�����ʽֻ��һ�γ���ת�� <br>
	 * 4.�������� stream �ڲ���ر���,��ִ����֮����������쳣<br>
	 * 5.���ʽ������ܵ�һ����,�ӿ�����һʵ��������<br>
	 * */
	static class Test4 {
		
		
		public static void main(String[] args) {
			List<Person> list1 = Person.ofList();
 			TimeHelper.start();
 			//sum ����
			long count = list1.stream().mapToInt(e -> e.getAge()).sum();
			//reduce ����
			long count2 = list1.stream().mapToInt(e -> e.getAge()).reduce(0, (a,b)->a+b);
 						
			//max ����
			OptionalInt max = list1.stream().mapToInt(e -> e.getAge()).max();
			//avg ����
			OptionalDouble count1 = list1.stream().mapToInt(e -> e.getAge()).average();
			
			//����ͳ�ƶ���
			IntSummaryStatistics statistics=list1.stream().mapToInt(e -> e.getAge()).summaryStatistics();
		
			//groupBy ����
			Map<Integer, List<Person>> map=list1.stream().collect(Collectors.groupingBy(Person::getAge));
			
			//collect ���Ͻ�������
			Collectors.toList();
			Collectors.toSet();
			
			//ÿ��it �ص�peek 
			list1.stream().filter(e->e.getAge()>2).mapToInt(e -> e.getAge()).peek( e->System.out.println("peek : "+e)).count();
			
			//�ӿ���ʵ��������
			list1.stream().forEach(System.out::println);
			
			//������
			list1.parallelStream().count();
			
			System.out.println("count : " + count);
			System.out.println("count2 : " + count2);
 			
			System.out.println("aver : " + count1.getAsDouble());
			System.out.println("max : " + max.getAsInt());
			System.out.println("statistics count : " + statistics.getCount());
			System.out.println("groupBy size : " + map.size());
			

			Map<String,String> m = new HashMap<>();
			m.getOrDefault("a", "5");
			m.merge("a", "addValue", (a,b)-> a+b);
			System.out.println("map merge : " + m.get("a"));
 	
			TimeHelper.end();
		}
	}
}
