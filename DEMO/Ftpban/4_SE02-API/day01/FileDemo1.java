package day01;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * �����ÿһ��ʵ�����Ա�ʾӲ���ϵ�һ���ļ���Ŀ¼��
 * ͨ���������:
 * �����ļ���Ŀ¼��������Ϣ(�ļ�������С���޸����ڵ�)
 * ����Ŀ¼�µ�����
 * �����ļ���Ŀ¼(������ɾ���ļ���Ŀ¼)
 * ���ǲ�����:
 * �����Է����ļ��б�������ݡ�
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		/*
		 * File�ڱ�ʾ�ļ���Ŀ¼ʱ����·��Ӧ��
		 * ʹ�����·�����������Ա���ƽ̨������
		 * ͨ���ģ�Ŀ¼�㼶�ָ�������ʹ��File
		 * �ṩ�ĳ���File.separator 
		 */
		File file = new File(
			"."+File.separator+"demo.txt"
		);
		
		/*
		 * ��ȡ������Ϣ
		 */
		//��ȡ�ļ���Ŀ¼������
		String fileName = file.getName();
		System.out.println("����:"+fileName);
		
		//ռ�õĴ��̿ռ䣬��λ���ֽ�
		long length = file.length();
		System.out.println("��С:"+length);
		
		/*
		 * boolean isFile()
		 * �жϵ�ǰFile�����ʾ���Ƿ����ļ�
		 */
		boolean isFile = file.isFile();
		System.out.println("�Ƿ����ļ�:"+isFile);
		
		//ͬ��Ҳ�����ж��Ƿ�ΪĿ¼
		boolean isDir = file.isDirectory();
		System.out.println("�Ƿ���Ŀ¼:"+isDir);
		//����޸�ʱ��
		long time = file.lastModified();		
		Date date = new Date(time);
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy��M��d�� HH:mm:ss"
			);
		System.out.println(sdf.format(date));
		
		file.canRead();
		file.canWrite();
		file.canExecute();
		file.isHidden();
	}
}








