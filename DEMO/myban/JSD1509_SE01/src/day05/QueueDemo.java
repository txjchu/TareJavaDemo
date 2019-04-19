package day05;

import java.util.LinkedList;
import java.util.Queue;
/**
 * java.util.Queue
 * ���У��洢һ��Ԫ�أ����ǶԴ�ȡ��Ҫ�󣬱�����ѭ���Ƚ��ȳ�ԭ��
 * ����Ҫ��ֻ�ܴӶ�β�����Ԫ�أ�����ֻ�ܻ�ȡ����Ԫ�ء�
 * 
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		/*
		 * ���ڶ��еı�����һ���Եģ����Զ��и����õĲ�������ɾԪ�ء�
		 * LinkedList������е�������ԣ�������Ҳ�Ƕ��е�ʵ���ࡣ
		 */
		Queue<String> queue=new LinkedList<String>();
		
		/*
		 * ��.offer();��
		 * �����ĩβ׷����Ԫ��
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		
		System.out.println(queue);
		
		/*
		 * E peek()
		 * ��ȡ����Ԫ�أ����ǲ������Ӳ�����
		 */
		
		String str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * E poll()
		 * ��ȡ����Ԫ�أ����������Ӳ�����ȡ�����Ԫ�ؼ��Ӷ����б�ɾ����
		 * 
		 */
		str =queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		System.out.println("��ʼ����");
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
		 * ͨ���������Ŷ�Ҫ��Ĳ���ʱʹ�á�
		 */
		
	}
}
