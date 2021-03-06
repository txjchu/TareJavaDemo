package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 存取元素遵循先进后出的原则。
 * 通常想实现有后退功能的操作时，可以使用栈结构保存内容。
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
			
	/*
	 * java中没有为栈结构单独设立接口。
	 * 而是使用双端队列实现。双端队列Deque是Queue的子类。
	 * 特点是可以从队列的两端分别进出队，若我们只调用从一侧进出队的方法则实现了栈结构。
	 * 为此，Java在双端队列接口中为栈定义了两个方法：push,pop;
	 * （pollFirst,pollLast,offerFirst,offerLast）
	 * 
	 * LinkedList实现了双端队列接口，由于其接口是Queue的子接口，所以LinkedList是
	 * 双端队列（Deque）也是队列（Queue）。	
	 */
		Deque<String> stack=new LinkedList<String>();
		/*
		 * void push(E e)
		 * 入栈操作，等效offerFirst方法。 
		 */
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		
		System.out.println(stack);
		
		//同样支持peek（返回队首元素但不删除），还有peekFirst,peekLast
		String str=stack.peek();
		System.out.println(str);
		System.out.println(stack);
		
		System.out.println("开始遍历：");//-----只能遍历一次
		while(stack.size()>0){
			str=stack.pop();
			System.out.println(str);
		}
		System.out.println(stack);
		
	}
}
