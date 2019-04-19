package day01.copy;

import java.io.File;
import java.io.FileFilter;

/**
 * ���ص�listFiles������	File[] listFiles(FileFilter filter)		filter(������)
 * ���ص�ǰĿ¼���������������Ҫ�������������������������������ڷ��ص������С�
 * 
 * FileFilter��һ���ӿڣ���һ�����󷽷���
 * boolean  accept(File file)
 * ��д�÷��������������������������ʱ�÷���Ӧ������true.
 * @author Administrator
 *
 */
public class FileDemo08 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰĿ¼�����������ԡ�.����ͷ������
		 */
		File dir = new File(".");
		System.out.println(dir.isDirectory());
		if(dir.isDirectory()){//��Ŀ¼
			/*
			 * ʹ�������ڲ������ʽ����һ���ļ���������ʵ�����ʵ����
			 */
			FileFilter filter = new FileFilter(){
				@Override
				public boolean accept(File file) {
					System.out.println("���ڹ��ˣ�"+ file.getName());
					return file.getName().startsWith(".");
				}
			};
			File[] subs = dir.listFiles(filter);
			for(File sub : subs){
				System.out.println(sub.getName());
			}
				
		}
		
	}
}



















