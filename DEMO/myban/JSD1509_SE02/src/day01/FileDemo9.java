package day01;

import java.io.File;

/**
 * ɾ���κθ�����File��������ʾ���ļ���Ŀ¼��
 * ������ɾ�����е������ļ���Ŀ¼��
 * ���ݹ���
 * @author Administrator
 *
 */
public class FileDemo9 {
	public static void main(String[] args) {
		File dir=new File("a");
		deleteFile(dir);
		
	}
	/*
	 * ��������File��������ʾ���ļ���Ŀ¼��ɾ��
	 */
	public static void deleteFile(File f){
		if(f.isDirectory()){
			//�Ƚ���������ɾ��----�ж�
			File[] subs = f.listFiles();
			for(File sub : subs){
				deleteFile(sub);
			}
		}
		f.delete();
	}
	
	
}
