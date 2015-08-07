package test.java8.example.fnexp;

import test.java8.example.fnexp.model.TestWork;

public class Test {
	public static void main(String[] args) {
		TestWork work = new TestWork();
		work.doTask((int m) -> {
			System.out.println(m);
		});
		
		Runnable r2 = () -> {
			System.out.println("Hello world two!");
		};		
		r2.run();
	}
}
