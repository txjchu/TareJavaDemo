package day01;

import java.io.File;

/**
 * ����һ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo4 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰ��Ŀ��Ŀ¼�´���Ŀ¼demo
		 */
		File dir = new File("demo");
		
		if(!dir.exists()){
			/*
			 * ����һ��Ŀ¼
			 */
			dir.mkdir();
			System.out.println("Ŀ¼�������!");
		}
		
		
	}
}







