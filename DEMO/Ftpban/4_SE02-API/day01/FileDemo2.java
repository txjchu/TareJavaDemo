package day01;

import java.io.File;
import java.io.IOException;

/**
 * ʹ��File����һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ����Ŀ��Ŀ¼�´���һ�����ļ�test.txt
		 * 
		 * ����д"./"Ĭ��Ҳ���ڵ�ǰ��Ŀ��Ŀ¼��
		 */
		File file = new File(
			"test.txt"
		);
		/*
		 * boolean exists()
		 * �ж�File��ʾ���ļ���Ŀ¼�Ƿ���ʵ����
		 * �����򷵻�true
		 */
		if(!file.exists()){
			//�������ļ�
			file.createNewFile();
			System.out.println("�ļ��������!");
		}
	}
	
}








