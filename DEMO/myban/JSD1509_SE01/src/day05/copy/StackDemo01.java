package day05.copy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈 	数据结构
 * 存取元素遵循先进后出的原则。FILO
 * 通常若想实现有后退功能的操作时，可以使用栈结构保存内容。
 * @author Administrator
 *
 */
public class StackDemo01 {
	public static void main(String[] args) {
		/*
		 * java中没有为栈结构单独设计接口。
		 * 而是使用双端队列Deque实现。双端队列Deque是队列Queue的子类，特点是可以从队列的两端分别进出队，
		 * 若我们只调用从一侧进出队的方法，则实现了栈结构。为此，java在双端队列接口中为栈定义了两个方法：
		 * push()入栈,	pop()出栈
		 * LinkedList实现了双端队列接口，由于其接口是Queue的子接口，所以LinkedList是的双端队列（Deque）也是队列（Queue）
		 * 
		 */
		Deque<String> stack = new LinkedList<String>();
		/*
		 * void  push(E e)
		 * 入栈操作，等效offerFirst方法-----(offer()方法是将元素存入队列队尾，offerFirst()则是存入队首)
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println(stack);//[four, three, two, one]
		
		//同样支持peek方法，还有peekFirst,peekLast
		String str = stack.peek();
		System.out.println(str);//four
		System.out.println(stack);//[four, three, two, one]
		
		System.out.println("开始遍历...");
		while(stack.size() > 0){
			str = stack.pop();
			System.out.println(str);//four....one
		}
		System.out.println(stack);//[]-----pop()出了栈中所有元素，因此stack中已经没有元素了。
	}
}













