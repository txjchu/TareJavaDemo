package day01;

import java.io.File;

/**
 * ɾ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo6 {
	public static void main(String[] args) {
		File dir = new File("a");
		if(dir.exists()){
			/*
			 * delete��ɾ��Ŀ¼��ǰ���Ǹ�Ŀ¼
			 * ������һ����Ŀ¼(�������κ�����)��
			 */
			dir.delete();
			System.out.println("ɾ��Ŀ¼���!");
		}
	}
}






