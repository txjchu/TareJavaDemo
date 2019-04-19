package day05;

import java.util.LinkedList;
import java.util.Queue;
/**
 * java.util.Queue
 * 队列：存储一组元素，但是对存取有要求，必须遵循：先进先出原则。
 * 队列要求只能从队尾添加新元素，并且只能获取队首元素。
 * 
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		/*
		 * 由于队列的遍历是一次性的，所以队列更常用的操作是增删元素。
		 * LinkedList满足队列的相关特性，所以它也是队列的实现类。
		 */
		Queue<String> queue=new LinkedList<String>();
		
		/*
		 * 【.offer();】
		 * 向队列末尾追加新元素
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue);
		
		/*
		 * E peek()
		 * 获取队首元素，但是不做出队操作。
		 */
		
		String str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * E poll()
		 * 获取队首元素，并且做出队操作，取出后该元素即从队列中被删除。
		 * 
		 */
		str =queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		System.out.println("开始遍历");
//		for(int i=queue.size();i>0;i--){
//			str=queue.poll();
//			System.out.println(str);
//		}
//		System.out.println(queue);
		
		while(queue.size()>0){
			str=queue.poll();
			System.out.println(str);
		}
		System.out.println(queue);
		/*
		 * 通常用在有排队要求的操作时使用。
		 */
		
	}
}
