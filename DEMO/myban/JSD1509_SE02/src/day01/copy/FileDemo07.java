package day01.copy;

import java.io.File;

/**
 * ��ȡһ��Ŀ¼�µ���������
 * @author Administrator
 *
 */
public class FileDemo07 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰĿ¼����Ŀ��Ŀ¼���µ���������==D:\Workspaces\MyEclipse 8.6\JSD1509_SE02
		 */
		File dir = new File(".");
//		File dir = new File("a");
		//ֻ��Ŀ¼�ſ��Ի�ȡ����
		System.out.println("dir�Ƿ���Ŀ¼��"+ dir.isDirectory());
		if(dir.isDirectory()){
			/*
			 * File[] listFiles()
			 * �÷����Ὣ��ǰĿ¼�µ�ÿһ��������һ��File�����ʾ��Ȼ����Щ�������������ʽ���ء�
			 */
			File[] subs = dir.listFiles();
			for(File sub : subs){
				System.out.println((sub.isFile() ? "�ļ�":"Ŀ¼")+":"+ sub.getName());
			}
		}
	}
}















