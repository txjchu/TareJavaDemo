package day01;

import java.io.File;
import java.io.FileFilter;

/**
 * ����listFiles����
 * File[] listFiles(FileFilter filter)
 * ���ص�ǰĿ¼���������������Ҫ����������
 * ���������������������ڷ��ص������С�
 * 
 * FileFilter��һ���ӿڣ���һ�����󷽷���
 * boolean accept()
 * ��д�÷��������������������������ʱ�÷���Ӧ������true��
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰĿ¼�����������ԡ�.����ͷ������
		 */
		File dir=new File(".");
		if(dir.isDirectory()){
			/*
			 * ʹ�������ڲ������ʽ����һ���ļ�������ʵ�����ʵ��
			 */
			FileFilter filter=new FileFilter(){
				public boolean accept(File file){
					//����������ڹ��˹����е��������-----���
					System.out.println("���ڹ��ˣ�"+file.getName());
					return file.getName().startsWith(".");
				}
			};
			
			File[] subs=dir.listFiles(filter);
			for(File sub : subs){
				System.out.println("Ŀ¼"+sub.getName());
			}
			
		}
		
	}
}
