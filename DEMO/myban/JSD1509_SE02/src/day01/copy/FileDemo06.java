package day01.copy;

import java.io.File;

/**
 * ɾ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo06 {
	public static void main(String[] args) {
		File dir = new 	File("a");
		System.out.println(dir.exists());
		if(dir.exists()){
			/*
			 * delete��ɾ��Ŀ¼��ǰ���Ǹ�Ŀ¼������һ����Ŀ¼���������κ����
			 */
			
			System.out.println("ɾ��Ŀ¼��ϣ�"+ dir.delete());
		}
	}
}
















