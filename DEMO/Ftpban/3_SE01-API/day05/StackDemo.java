package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ
 * ��ȡԪ����ѭ�Ƚ����ԭ��
 * ͨ������ʵ���к��˹��ܵĲ���ʱ����ʹ��ջ�ṹ����
 * ���ݡ�
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		
		/*
		 * java��û��Ϊջ�ṹ���������ӿڡ�
		 * ����ʹ��˫�˶���ʵ�֡�˫�˶���Deque��
		 * ����Queue�����ࡣ�ص��ǿ��ԴӶ��е�����
		 * �ֱ�����ӣ�������ֻ���ô�һ������ӵ�
		 * ������ʵ����ջ�ṹ��Ϊ�ˣ�java��˫�˶���
		 * �ӿ���Ϊջ��������������:push,pop
		 * 
		 * LinkedListʵ����˫�˶��нӿڣ�������ӿ�
		 * ��Queue���ӽӿڣ�����LinkedList��˫��
		 * ����(Deque)Ҳ�Ƕ���(Queue)
		 */
		Deque<String> stack
			= new LinkedList<String>();
		/*
		 * void push(E e)
		 * ��ջ��������ЧofferFirst����
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println(stack);
		
		//ͬ��֧��peek,����peekFirst,peekLast
		String str = stack.peek();
		System.out.println(str);
		System.out.println(stack);
		
		System.out.println("��ʼ����:");
		while(stack.size()>0){
			str = stack.pop();
			System.out.println(str);
		}
		System.out.println(stack);
		
	}
}






