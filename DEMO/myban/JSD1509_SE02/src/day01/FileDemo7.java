package day01;

import java.io.File;

/**
 * ��ȡһ��Ŀ¼�µ���������
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰĿ¼����Ŀ��Ŀ¼���µ���������
		 */
		File dir = new File(".");
		//ֻ��Ŀ¼�ſ��Ի�ȡ����
		if(dir.isDirectory()){
			/*
			 * File[] listFiles()
			 * �÷����Ὣ��ǰĿ¼�µ�ÿһ��������һ��File�����ʾ��
			 * Ȼ����Щ�������������ʽ���ء�
			 */
			File[] subs =dir.listFiles();
			for(File sub : subs){
			
				System.out.println((sub.isFile()?"�ļ�":"Ŀ¼")+":"+sub.getName());
			}
			
		}
		
		
	}
}
