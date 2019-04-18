package day04;
/**
 * 线程:通常用于解决同时运行多个任务
 * "同时"是感官上，实际上多个线程之间是走走停停的
 * 并发运行方式。
 * 
 * 创建线程有两种方式:
 * 第一种，直接继承Thread类并重写run方法来
 * 定义线程要执行的任务代码
 * @author Administrator
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * 启动线程要执行start方法。使其被纳入到
		 * 线程调度中。一旦线程调度将CPU时间片段
		 * 分配给当前线程，那么当前线程的run方法
		 * 就自动被调用开始执行。
		 * start执行的过程中run方法是不会被调用的，
		 * 但是执行完毕后run方法会很快的被执行起来。
		 */
		t1.start();
		t2.start();
	}
}
/**
 * 第一种创建线程的方式有两个不足：
 * 1:由于java是单继承，所以当前类若继承了Thread类
 *   后就不能再继承其他类，这对于系统架构设计来讲很
 *   不理想。
 * 2:线程内部重写run方法来定义任务导致了线程与任务
 *   有一个强耦合关系，线程会变得重用性，灵活度非常
 *   差  
 * 优点:
 * 定义简单，所以常被用作匿名内部类的创建方式。
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的!");
		}
	}
}






