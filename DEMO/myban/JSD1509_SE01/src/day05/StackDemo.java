package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ
 * ��ȡԪ����ѭ�Ƚ������ԭ��
 * ͨ����ʵ���к��˹��ܵĲ���ʱ������ʹ��ջ�ṹ�������ݡ�
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
			
	/*
	 * java��û��Ϊջ�ṹ���������ӿڡ�
	 * ����ʹ��˫�˶���ʵ�֡�˫�˶���Deque��Queue�����ࡣ
	 * �ص��ǿ��ԴӶ��е����˷ֱ�����ӣ�������ֻ���ô�һ������ӵķ�����ʵ����ջ�ṹ��
	 * Ϊ�ˣ�Java��˫�˶��нӿ���Ϊջ����������������push,pop;
	 * ��pollFirst,pollLast,offerFirst,offerLast��
	 * 
	 * LinkedListʵ����˫�˶��нӿڣ�������ӿ���Queue���ӽӿڣ�����LinkedList��
	 * ˫�˶��У�Deque��Ҳ�Ƕ��У�Queue����	
	 */
		Deque<String> stack=new LinkedList<String>();
		/*
		 * void push(E e)
		 * ��ջ��������ЧofferFirst������ 
		 */
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		
		System.out.println(stack);
		
		//ͬ��֧��peek�����ض���Ԫ�ص���ɾ����������peekFirst,peekLast
		String str=stack.peek();
		System.out.println(str);
		System.out.println(stack);
		
		System.out.println("��ʼ������");//-----ֻ�ܱ���һ��
		while(stack.size()>0){
			str=stack.pop();
			System.out.println(str);
		}
		System.out.println(stack);
		
	}
}
