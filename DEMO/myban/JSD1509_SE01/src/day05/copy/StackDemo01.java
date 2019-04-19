package day05.copy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ 	���ݽṹ
 * ��ȡԪ����ѭ�Ƚ������ԭ��FILO
 * ͨ������ʵ���к��˹��ܵĲ���ʱ������ʹ��ջ�ṹ�������ݡ�
 * @author Administrator
 *
 */
public class StackDemo01 {
	public static void main(String[] args) {
		/*
		 * java��û��Ϊջ�ṹ������ƽӿڡ�
		 * ����ʹ��˫�˶���Dequeʵ�֡�˫�˶���Deque�Ƕ���Queue�����࣬�ص��ǿ��ԴӶ��е����˷ֱ�����ӣ�
		 * ������ֻ���ô�һ������ӵķ�������ʵ����ջ�ṹ��Ϊ�ˣ�java��˫�˶��нӿ���Ϊջ����������������
		 * push()��ջ,	pop()��ջ
		 * LinkedListʵ����˫�˶��нӿڣ�������ӿ���Queue���ӽӿڣ�����LinkedList�ǵ�˫�˶��У�Deque��Ҳ�Ƕ��У�Queue��
		 * 
		 */
		Deque<String> stack = new LinkedList<String>();
		/*
		 * void  push(E e)
		 * ��ջ��������ЧofferFirst����-----(offer()�����ǽ�Ԫ�ش�����ж�β��offerFirst()���Ǵ������)
		 */
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println(stack);//[four, three, two, one]
		
		//ͬ��֧��peek����������peekFirst,peekLast
		String str = stack.peek();
		System.out.println(str);//four
		System.out.println(stack);//[four, three, two, one]
		
		System.out.println("��ʼ����...");
		while(stack.size() > 0){
			str = stack.pop();
			System.out.println(str);//four....one
		}
		System.out.println(stack);//[]-----pop()����ջ������Ԫ�أ����stack���Ѿ�û��Ԫ���ˡ�
	}
}













