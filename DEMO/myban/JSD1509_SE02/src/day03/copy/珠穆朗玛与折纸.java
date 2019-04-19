package day03.copy;

import org.junit.Test;

/**
 * 题目：（分别用for循环和while循环实现）
 * 1.珠穆朗玛峰高度为8848米，有一张足够大的纸，厚度为0.0001米。
 * 2.请问，折叠多少次，可以折成珠穆朗玛峰的高度。
 * @author Administrator
 *
 */
public class 珠穆朗玛与折纸 {
	
	//while循环
	@Test
	public void testWhile(){
		
		System.out.println(1.22 > 1);//true
		System.out.println(1.001 < 1);//flase
		System.out.println(0.00009 < 1);//true
		System.out.println(1 < 0.008);//flase
				
		long count = 0L;	 //计折叠次数
		long h = 8848L;		 //峰的高度
		double ply = 0.0001;//纸的厚度	ply 厚度
		double plys = 0;
		while(plys < h){
			ply *= 2;//折一次，纸的厚度x2。
			plys = ply;
			count ++;//次数加1
		}
		System.out.println(plys);
		System.out.println("一共折了"+ count +"次！");
	}
	
	@Test
	//for循环
	public void testFor(){
		long count = 0L;		//计折叠次数
		long h = 8848L;			//峰的高度
		double ply = 0.0001;	//纸的厚度 
		double plys = 0L;
		for(int i = 0; ; i++){
			ply *= 2;			//折叠一次ply纸的厚度x2
			plys = ply;
			count ++;
			if(plys >= h){
				break;
			}
		}
		System.out.println(plys);
		System.out.println("一共折叠了"+ count +"次！");
	}
}
