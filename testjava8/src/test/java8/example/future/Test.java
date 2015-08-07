package test.java8.example.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

//切换的成本
//一个线程阻塞时，以前执行该线程的处理器核心会转而执行另一个线程。以前执行的线程的执行状态必须保存到内存中，并加载新线程的状态。这种将核心从运行一个线程切换到运行另一个线程的操作称为上下文切换。
//除了直接的上下文切换性能成本，新线程一般会使用来自前一个线程的不同数据。内存访问比处理器时钟慢得多，所以现代系统会在处理器核心与主要内存之间使用多层缓存。尽管比主要内存快得多，但缓存的容量也小得多（一般而言，缓存越快，容量越小），所以任何时刻只能在缓存中保存总内存的小部分。发生线程切换且一个核心开始执行一个新线程时，新线程需要的内存数据可能不在缓存中，所以该核心必须等待该数据从主要内存加载。
//组合的上下文切换和内存访问延迟，会导致直接的显著性能成本
public class Test {

	public static void main(String[] args) {
		CompletableFuture<Long> t=new CompletableFuture<>();
		 
	}
}
