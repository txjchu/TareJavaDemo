package day04.hw04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**
 * 课后作业
 * @author Administrator
 *
 */
public class Exercise {
	
	//第一题	
	@Test
	public void testAddAllAndContainsAll(){
		Collection<String> c1 = new ArrayList<String>();
		c1.add("terry");
		c1.add("allen");
		System.out.println(c1);
		Collection<String> c2 = new HashSet<String>();//[terry, allen]
		c2.addAll(c1);
		System.out.println(c2);
		Collection<String> c3 = new ArrayList<String>();//[allen, terry]
		c3.add("terry");
		System.out.println(c3);//[terry]
		System.out.println(c1.containsAll(c3));//true
	}
	
	//第7题
	@Test
	public void TestComparator(){
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp("张三", 22, "男", 3000));
		list.add(new Emp("李四", 23, "女", 4000));
		list.add(new Emp("王五", 25, "男", 4500));
		list.add(new Emp("赵六", 23, "女", 4400));
		System.out.println(list);
		//[张三,22,男,3000.0, 李四,23,女,4000.0, 王五,25,男,4500.0, 赵六,23,女,4400.0]
		
		Collections.sort(list, new Comparator<Emp>(){
			public int compare(Emp e1, Emp e2) {				
				return (int) (e1.getSalary() - e2.getSalary());
			}			
		});
		System.out.println(list);
		//[张三,22,男,3000.0, 李四,23,女,4000.0, 赵六,23,女,4400.0, 王五,25,男,4500.0]
	}
	
}










