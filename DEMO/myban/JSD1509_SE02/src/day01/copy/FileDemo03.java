package day01.copy;

import java.io.File;

/**
 * ɾ��һ�������ļ�
 * @author Administrator
 *
 */
public class FileDemo03 {
	public static void main(String[] args) {
		/*
		 * ����Ŀ��Ŀ¼�µ��ļ�test.txtɾ��
		 */
		File file = new File("test.txt");
		if(file.exists()){
			file.delete();
			//ɾ��file��ʾ���ļ���Ŀ¼
			System.out.println("ɾ����ϣ�");
		}
		System.out.println(file.exists());
	}
}


















