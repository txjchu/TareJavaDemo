package day01.copy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * �����ÿһ��ʵ�����Ա�ʾӲ���ϵ�һ���ļ���Ŀ¼��
 * ͨ�����ʸ�����ԣ�
 * �����ļ���Ŀ¼��������Ϣ���ļ�������С���޸����ڵȣ�������Ŀ�µ���������ļ���Ŀ¼��������ɾ���ļ���Ŀ¼��
 * ���ǲ����ԣ�
 * �����Է����ļ��б�������ݡ�
 * @author Administrator
 *
 */
public class FileDemo01 {
	public static void main(String[] args) {
		/*
		 * File�ڱ�ʾ�ļ���Ŀ¼ʱ����·��Ӧ��ʹ�����·�����������Ա���ƽ̨�����ԡ�
		 * ͨ���ģ�Ŀ¼�㼶�ָ�������ʹ��File�ṩ�ĳ���File.separator
		 * 
		 */
		File file = new File("."+ File.separator +"demo.txt");
		/*
		 * ��ȡ�ļ���������Ϣ��
		 */
		String fileName = file.getName();
		System.out.println("�ļ������֣�"+ fileName);//�ļ������֣�demo.txt
		//ռ�õĴ��̿ռ䣬��λ���ֽ�
		long length = file.length();
		System.out.println("��С��"+ length);//��С��2
		/*
		 * boolean isFile()
		 * �жϵ�ǰFile�����ʾ���Ƿ����ļ���
		 */
		boolean isFile = file.isFile();
		System.out.println("�Ƿ����ļ���"+ isFile);//�Ƿ����ļ���true
		//ͬ��Ҳ�����ж��Ƿ���Ŀ¼
		boolean isDir = file.isDirectory();
		System.out.println("�Ƿ���Ŀ¼��"+ isDir);//�Ƿ���Ŀ¼��false
		//����޸�ʱ��
		long time = file.lastModified();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy��M��d��  HH:mm:ss"); 
		System.out.println(sdf.format(date));//2015��11��2��  10:45:15
		
		System.out.println("�Ƿ�ɶ���"+ file.canRead());//�Ƿ�ɶ���true
		System.out.println("�Ƿ��д�룺"+ file.canWrite());//�Ƿ��д�룺true
		System.out.println("�Ƿ��ִ�У�"+ file.canExecute());//�Ƿ��ִ�У�true
		System.out.println("�Ƿ����أ�"+ file.isHidden());//�Ƿ����أ�false
		
	}
}























