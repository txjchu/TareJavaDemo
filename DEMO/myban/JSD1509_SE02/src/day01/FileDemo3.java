package day01;

import java.io.File;

/**
 * ɾ��һ�������ļ�
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * ����Ŀ��Ŀ¼�µ��ļ�test.txtɾ��
		 */
		File file=new File("test.txt");
		if(file.exists()){
			file.delete();
			System.out.println("ɾ����ϣ�");
		}
		
		
	}
}
