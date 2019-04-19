package day01;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * �����ÿһ��ʵ�����Ա�ʾӲ���ϵ�һ���ļ���Ŀ¼��
 * ͨ��������ԣ�
 * �����ļ���Ŀ¼��������Ϣ���ļ�������С���޸����ڵȣ���
 * ����Ŀ¼�µ����
 * �����ļ���Ŀ¼��������ɾ���ļ���Ŀ¼����
 * ���ǲ����ԣ�
 * �����Է����ļ��б�������ݡ�
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		File file=new File("."+File.separator+"demo.txt");
		/*
		 * File �ڱ�ʾ�ļ���Ŀ¼ʱ����·��Ӧ��ʹ�����·����
		 * �������Ա���ƽ̨�����ԡ�
		 * ͨ���ģ�Ŀ¼�㼶�ָ�������ʹ��File�ṩ�ĳ���File.separator
		 */
		
		/*
		 * ��ȡ������Ϣ
		 */
		//��ȡ�ļ���Ŀ¼������
		String fileName=file.getName();
		System.out.println("���֣�"+fileName);
		
		//ռ�õĴ��̿ռ䣬��λ���ֽ�
		long length=file.length();
		System.out.println("�ļ���С��"+length);
		
		/*
		 * boolean isFile()
		 * �жϵ�ǰFile�����ʾ���Ƿ����ļ�
		 */
		boolean isFile=file.isFile();
		System.out.println("�Ƿ����ļ���"+isFile);
		
		//ͬ��Ҳ�����ж��Ƿ�ΪĿ¼
		boolean isDir=file.isDirectory();
		System.out.println("�Ƿ���Ŀ¼��"+isDir);
		
		//�����޸�ʱ��---���
		long time =file.lastModified();
		Date date=new Date(time);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy��M��d�� HH:mm:ss");
		System.out.println(sdf.format(date));
		
//		boolean file.canRead();
//		boolean file.canWrite();
//		boolean file.canExecute();
//		boolean 
	}
	
}
