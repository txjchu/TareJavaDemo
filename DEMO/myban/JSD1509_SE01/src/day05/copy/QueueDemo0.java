package day05.copy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * ���С��洢һ��Ԫ�أ����ǶԴ�ȡ��Ҫ�󣬱�����ѭ���Ƚ��ȳ�ԭ��FIFO��
 * ����Ҫ��ֻ�ܴӶ�β�����Ԫ�أ��Ӷ����ó�Ԫ�ء�
 * @author Administrator
 *
 */
public class QueueDemo0 {
	public static void main(String[] args) {
		/*
		 * ���ڶ��б�����һ���Եģ����Զ��и����õĲ�������ɾԪ�ء�
		 * LinkedList������е�������ԣ�������Ҳ�Ƕ��е�ʵ���ࡣ
		 */
		Queue<String> queue = new LinkedList<String>();
		/*
		 * boolean offer(E e)
		 * �����ĩβ׷����Ԫ��
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);//[one, two, three, four]
		/*
		 * E peek()
		 * ��ȡ����Ԫ�أ����ǲ������ӣ�ɾ��������
		 */
		String str = queue.peek();
		System.out.println(str);//one
		System.out.println(queue);//[one, two, three, four]
		/*
		 * E  poll()
		 * ��ȡ����Ԫ�أ����������ӣ�ɾ����������
		 */
		str = queue.poll();
		System.out.println(str);//one 
		System.out.println(queue);//[two, three, four]
		
		System.out.println("��ʼ����...");
//		for(int i = queue.size(); i > 0; i --){
//			str = queue.poll();
//			System.out.println(str);
//		}
//		System.out.println(queue);//[]
		
		while(queue.size() > 0){
			str = queue.poll();
			System.out.println(str);
		}
		System.out.println(queue);
	}
}














