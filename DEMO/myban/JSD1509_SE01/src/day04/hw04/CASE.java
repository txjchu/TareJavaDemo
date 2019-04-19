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
 * CASE 案例
 * @author Administrator
 *
 */
public class CASE {
	
	//案例1
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
	
	//案例2
	@Test
	public void testHasNextandNext(){
		Collection<String> c = new HashSet<String>();
		c.add("java");
		c.add("cpp");
		c.add("php");
		c.add("c#");
		c.add("objective-c");
		System.out.println(c);//[cpp, php, c#, java, objective-c]
		
		Iterator<String> it = c.iterator();//创建时加上泛型
//		for(String str : c){//使用增强for循环即是使用迭代器
//			System.out.println(str);
//		}
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
	}
		
		//案例3
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
				String str = it.next();//遍历集合
				if(str.indexOf("c") != -1){//当一个字符串中不包含某个字符时，indexOf(char c)方法返回-1。
					it.remove();//调用迭代器的remove()方法删除该元素
				}
			}
			System.out.println(c);//[php, java]
		}
		
		//案例4
		@Test
		public void testForeach(){
			Collection<String> c = new HashSet<String>();
			c.add("java");
			c.add("c#");
			c.add("php");
			c.add("cpp");
			c.add("objective-c");
			System.out.println(c);//[cpp, php, c#, java, objective-c]
			for(String str : c){//使用增强for循环遍历集合
				System.out.print(str.toUpperCase() +" ");//CPP PHP C# JAVA OBJECTIVE-C
			}
		}
		
		//案例5
		@Test
		public void testGetAndSet(){
			List<String> list = new ArrayList<String>();//创建List引用的集合
			list.add("java");
			list.add("cpp");
			list.add("php");
			list.add("c#");
			list.add("objective-c");
			System.out.println(list);
			
			for(int i = 0; i < list.size(); i ++){
				String str = list.get(i).toUpperCase();//toUpperCase()方法不改变原集合中的元素。
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
		
		//案例6
		@Test
		public void testInsertAndRemove(){
			List<String> list = new ArrayList<String>();//创建List接口的引用
			list.add("java");
			list.add("c#");
			System.out.println(list);//[java, c#]
			
			list.add(1, "cpp");//将cpp插入到索引为1的位置
			System.out.println(list);//[java, cpp, c#]
			
			list.remove(2);//移除索引为2的元素
			System.out.println(list);//[java, cpp]
		}
		
		//案例7
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
//				list.remove(i);//=====错误用法，每使用一次remove()方法，被删除的元素后面的元素下标全部-1。
//			}
//			list.remove(3);
//			list.remove(7);//当再次使用remove()时，下标为7的元素已经变成8。
			list.subList(3, 8).clear();
			System.out.println(list);//[0, 1, 2, 8, 9]			
		}
		
		//案例8
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
		
		//案例9	数组转化为集合
		@Test
		public void testArrayToList(){
			String[] strArr = {"a", "b", "c"};
			System.out.println(Arrays.toString(strArr));//[a, b, c]
			List<String> list = Arrays.asList(strArr);
			System.out.println(list);//[a, b, c]
			
//			list.add(1,"d");//抛出异常java.lang.UnsupportedOperationException
			System.out.println(list.getClass().getName());//java.util.Arrays$ArrayList
									  //Arrays$ArrayList表示Arrays的内部类ArrayList
			
			//数组转换而来的集合的正确使用方式
			List<String> list1 = new ArrayList<String>();
			list1.addAll(list);
			System.out.println(list1);//[a, b, c]
		}
		
		//案例10		Comparable 可比较的
		@Test
		public void testSort(){
			List<Integer> list = new ArrayList<Integer>();
			Random ran = new Random();
			for(int i = 0; i < 10; i ++){
				list.add(ran.nextInt(100));
			}
			System.out.println(list);//[0, 35, 8, 82, 10, 29, 14, 20, 70, 67]
			Collections.sort(list);//调用Collections.sort(list)的方法进行升序排列
			System.out.println(list);//[0, 8, 10, 14, 20, 29, 35, 67, 70, 82]
		}
		
		//案例11	
		@Test
		public void testComparator(){//比较仪
			List<Cell> list = new ArrayList<Cell>();
			list.add(new Cell(2, 3));
			list.add(new Cell(5, 1));
			list.add(new Cell(3, 2));
			System.out.println(list);//[2,3, 5,1, 3,2]
			
			Collections.sort(list, new Comparator<Cell>(){//第二个参数为比较器接口，需要重写比较方法
				/*
				 * 重写compare比较方法，以cell对象的col值做比较依据。
				 * 该方法返回值为以0为界限的取值范围，等于0表示两个对象相等。
				 */
				@Override
				public int compare(Cell o1, Cell o2) {					
					return o1.getCol() - o2.getCol();
				}				
			});
			System.out.println(list);//[5,1, 3,2, 2,3]
		}
		
		//案例12	队列LinkedList
		@Test
		public void testQueue(){
			Queue<String> queue = new LinkedList<String>();
			queue.offer("a");
			queue.offer("b");
			queue.offer("c");
			System.out.println(queue);//[a, b, c]
			String str = queue.peek();//获取队列队首元素
			System.out.println(str);//a
//			for(int i = 0; queue.size() != 0; i ++){
//				str = queue.poll();
//				System.out.print(str +" ");//a b c 
//			}
			while(queue.size() > 0){//只要队列中有元素，就执行
				str = queue.poll();//删除队首元素
				System.out.print(str + " ");//a b c 
			}
		}
		
		//案例13		测试双端队列
		@Test
		public void testDeque(){
			Deque<String> deque = new LinkedList<String>();
			deque.push("a");
			deque.push("b");
			deque.push("c");
			System.out.println(deque);//[c, b, a]
			
			String str = deque.peek();//获取队首元素
			System.out.println(str);//c
			
			while(deque.size() > 0){
				str = deque.pop();
				System.out.print(str +" ");//c b a 
			}
			
			
		}
		
}













