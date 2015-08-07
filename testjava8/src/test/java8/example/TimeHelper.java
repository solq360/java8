package test.java8.example;
public abstract class TimeHelper {

	private static long _start1;
	private static long _start2;

	public static void start() {
		_start1 = System.nanoTime();
		_start2 = System.currentTimeMillis();
	}

	public static void end() {
		final long t1= System.nanoTime() - _start1;
		final long t2= System.currentTimeMillis() - _start2;
		System.out.println((t1) / 1.0e9);
		System.out.println("nanoTime : " + t1);
		System.out.println("time : " + t2);
	}
}
