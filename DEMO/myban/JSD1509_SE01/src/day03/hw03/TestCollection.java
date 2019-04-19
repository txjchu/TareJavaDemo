package day03.hw03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import day03.Cell;

/**
 * 案例10、11、12、13题
 * @author Administrator
 *
 */
public class TestCollection {
	public static void main(String[] args) {
	}
	//案例10题
	@Test
	public void testRef(){
		Collection<Cell> cells = new ArrayList<Cell>();
		Cell c1 = new Cell(1, 2);
		cells.add(c1);
		System.out.println(cells);//[[1,2]]
		
		Cell cell = new Cell(2, 3);
		cells.add(cell);
		System.out.println(cell);//[2,3]
		System.out.println(cells);//[[1,2], [2,3]]
		cell.drop();
		System.out.println(cell);//[3,3]
		System.out.println(cells);//[[1,2], [3,3]]
	}
	
	@Test
	//案例11题
	public void testAdd(){
		Collection<String> c = new ArrayList<String>();
		System.out.println(c);
		c.add("a");
		c.add("b");
		c.add("c");
		System.out.println(c);
	}
		
	@Test
	//案例12题
	public void testContains(){
		Collection<Cell> c = new ArrayList<Cell>();
		c.add(new Cell(1, 2));
		c.add(new Cell(1, 3));
		c.add(new Cell(2, 2));
		c.add(new Cell(2, 3));
		System.out.println(c);
		
		Cell cell = new Cell(2, 5);
		boolean flag = c.contains(cell);
		System.out.println("对象cell是否包含在集合c中："+ flag);
		
	}
	
	@Test
	//13题
	public void testSizeAndClearAndIsEmpty(){
		Collection<String> c = new HashSet<String>();
		System.out.println("isEmpty:"+ c.isEmpty());//isEmpty:true
		
		c.add("java");
		c.add("php");
		c.add("cpp");
		c.add("c#");
		c.add("Objective-c");
		System.out.println("isEmpty:"+ c.isEmpty() +",SIZE:"+ c.size());//isEmpty:false,SIZE:5
		
		c.clear();
		System.out.println("isEmpty:"+ c.isEmpty() +",SIZE:"+ c.size());//isEmpty:true,SIZE:0
	}
}










