package day04.hw04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.junit.Test;

/**
 * CASE ����
 * @author Administrator
 *
 */
public class CASE {
	
	//����1
	@Test
	public void testAddAllandContainsAll(){
		Collection<String> c1 = new ArrayList<String>();
		c1.add("java");
		c1.add("cpp");
		c1.add("php");
		c1.add("c#");
		c1.add("objective-c");
		System.out.println(c1);//[java, cpp, php, c#, objective-c]
		
		Collection<String> c2 = new HashSet<String>();
		c2.addAll(c1);
		System.out.println(c2);//[cpp, php, c#, java, objective-c]
		
		Collection<String> c3 = new ArrayList<String>();
		c3.add("java");
		c3.add("cpp");
		System.out.println(c1.containsAll(c3));//true
	}
	
	//����2
	@Test
	public void testHasNextandNext(){
		Collection<String> c = new HashSet<String>();
		c.add("java");
		c.add("cpp");
		c.add("php");
		c.add("c#");
		c.add("objective-c");
		System.out.println(c);//[cpp, php, c#, java, objective-c]
		
		Iterator<String> it = c.iterator();//����ʱ���Ϸ���
//		for(String str : c){//ʹ����ǿforѭ������ʹ�õ�����
//			System.out.println(str);
//		}
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
	}
		
		//����3
		@Test
		public void testRemove(){
			Collection<String> c = new HashSet<String>();
			c.add("java");
			c.add("php");
			c.add("c#");
			c.add("cpp");
			c.add("objective-c");
			System.out.println(c);//[cpp, php, c#, java, objective-c]
			
			Iterator<String> it = c.iterator();
			while(it.hasNext()){
				String str = it.next();//��������
				if(str.indexOf("c") != -1){//��һ���ַ����в�����ĳ���ַ�ʱ��indexOf(char c)��������-1��
					it.remove();//���õ�������remove()����ɾ����Ԫ��
				}
			}
			System.out.println(c);//[php, java]
		}
		
		//����4
		@Test
		public void testForeach(){
			Collection<String> c = new HashSet<String>();
			c.add("java");
			c.add("c#");
			c.add("php");
			c.add("cpp");
			c.add("objective-c");
			System.out.println(c);//[cpp, php, c#, java, objective-c]
			for(String str : c){//ʹ����ǿforѭ����������
				System.out.print(str.toUpperCase() +" ");//CPP PHP C# JAVA OBJECTIVE-C
			}
		}
		
		//����5
		@Test
		public void testGetAndSet(){
			List<String> list = new ArrayList<String>();//����List���õļ���
			list.add("java");
			list.add("cpp");
			list.add("php");
			list.add("c#");
			list.add("objective-c");
			System.out.println(list);
			
			for(int i = 0; i < list.size(); i ++){
				String str = list.get(i).toUpperCase();//toUpperCase()�������ı�ԭ�����е�Ԫ�ء�
//				str.toUpperCase();
				System.out.print(str +" ");
			}
//			System.out.println(list);
			
			String str = list.set(1, "c++");
			System.out.println(str);//cpp
			System.out.println(list);//[java, c++, php, c#, objective-c]
			
			str = list.get(3);
			list.set(3, list.set(1, str));
//			list.set(1, list.set(3, list.get(1)));
			System.out.println(list);//[java, c#, php, c++, objective-c]
		}
		
		//����6
		@Test
		public void testInsertAndRemove(){
			List<String> list = new ArrayList<String>();//����List�ӿڵ�����
			list.add("java");
			list.add("c#");
			System.out.println(list);//[java, c#]
			
			list.add(1, "cpp");//��cpp���뵽����Ϊ1��λ��
			System.out.println(list);//[java, cpp, c#]
			
			list.remove(2);//�Ƴ�����Ϊ2��Ԫ��
			System.out.println(list);//[java, cpp]
		}
		
		//����7
		@Test
		public void testSubList(){
			List<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < 10; i ++){
				list.add(i);
			}
			System.out.println(list);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
			List<Integer> subList = list.subList(3, 8);
			System.out.println(subList);//[3, 4, 5, 6, 7]
			for(int i = 0; i < subList.size(); i ++){
				subList.set(i, subList.get(i) * 10);
			}
			System.out.println(subList);//[30, 40, 50, 60, 70]
			System.out.println(list);//[0, 1, 2, 30, 40, 50, 60, 70, 8, 9]
			System.out.println(list.size());
//			Iterator it = list.iterator();
//			for(int i = 3; i < 8; i ++){
//				list.remove(i);//=====�����÷���ÿʹ��һ��remove()��������ɾ����Ԫ�غ����Ԫ���±�ȫ��-1��
//			}
//			list.remove(3);
//			list.remove(7);//���ٴ�ʹ��remove()ʱ���±�Ϊ7��Ԫ���Ѿ����8��
			list.subList(3, 8).clear();
			System.out.println(list);//[0, 1, 2, 8, 9]			
		}
		
		//����8
		@Test
		public void testToArray(){
			List<String> list = new ArrayList<String>();
			list.add("a");
			list.add("b");
			list.add("c");
			System.out.println(list);//[a, b, c]
			
			String[] arr =  list.toArray(new String[]{});
			System.out.println(Arrays.toString(arr));//[a, b, c]
		}
		
		//����9	����ת��Ϊ����
		@Test
		public void testArrayToList(){
			String[] strArr = {"a", "b", "c"};
			System.out.println(Arrays.toString(strArr));//[a, b, c]
			List<String> list = Arrays.asList(strArr);
			System.out.println(list);//[a, b, c]
			
//			list.add(1,"d");//�׳��쳣java.lang.UnsupportedOperationException
			System.out.println(list.getClass().getName());//java.util.Arrays$ArrayList
									  //Arrays$ArrayList��ʾArrays���ڲ���ArrayList
			
			//����ת�������ļ��ϵ���ȷʹ�÷�ʽ
			List<String> list1 = new ArrayList<String>();
			list1.addAll(list);
			System.out.println(list1);//[a, b, c]
		}
		
		//����10		Comparable �ɱȽϵ�
		@Test
		public void testSort(){
			List<Integer> list = new ArrayList<Integer>();
			Random ran = new Random();
			for(int i = 0; i < 10; i ++){
				list.add(ran.nextInt(100));
			}
			System.out.println(list);//[0, 35, 8, 82, 10, 29, 14, 20, 70, 67]
			Collections.sort(list);//����Collections.sort(list)�ķ���������������
			System.out.println(list);//[0, 8, 10, 14, 20, 29, 35, 67, 70, 82]
		}
		
		//����11	
		@Test
		public void testComparator(){//�Ƚ���
			List<Cell> list = new ArrayList<Cell>();
			list.add(new Cell(2, 3));
			list.add(new Cell(5, 1));
			list.add(new Cell(3, 2));
			System.out.println(list);//[2,3, 5,1, 3,2]
			
			Collections.sort(list, new Comparator<Cell>(){//�ڶ�������Ϊ�Ƚ����ӿڣ���Ҫ��д�ȽϷ���
				/*
				 * ��дcompare�ȽϷ�������cell�����colֵ���Ƚ����ݡ�
				 * �÷�������ֵΪ��0Ϊ���޵�ȡֵ��Χ������0��ʾ����������ȡ�
				 */
				@Override
				public int compare(Cell o1, Cell o2) {					
					return o1.getCol() - o2.getCol();
				}				
			});
			System.out.println(list);//[5,1, 3,2, 2,3]
		}
		
		//����12	����LinkedList
		@Test
		public void testQueue(){
			Queue<String> queue = new LinkedList<String>();
			queue.offer("a");
			queue.offer("b");
			queue.offer("c");
			System.out.println(queue);//[a, b, c]
			String str = queue.peek();//��ȡ���ж���Ԫ��
			System.out.println(str);//a
//			for(int i = 0; queue.size() != 0; i ++){
//				str = queue.poll();
//				System.out.print(str +" ");//a b c 
//			}
			while(queue.size() > 0){//ֻҪ��������Ԫ�أ���ִ��
				str = queue.poll();//ɾ������Ԫ��
				System.out.print(str + " ");//a b c 
			}
		}
		
		//����13		����˫�˶���
		@Test
		public void testDeque(){
			Deque<String> deque = new LinkedList<String>();
			deque.push("a");
			deque.push("b");
			deque.push("c");
			System.out.println(deque);//[c, b, a]
			
			String str = deque.peek();//��ȡ����Ԫ��
			System.out.println(str);//c
			
			while(deque.size() > 0){
				str = deque.pop();
				System.out.print(str +" ");//c b a 
			}
			
			
		}
		
}













