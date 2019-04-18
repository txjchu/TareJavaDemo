package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��д�ַ���
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"test.txt","rw"	
			);
		
		String str = "Ħ��Ħ��,��ħ��Ĳ���";
		/*
		 * �ַ����ṩ�˽�����ת��Ϊ��Ӧ�ı���ķ���
		 * 
		 * byte[] getBytes()
		 * ���յ�ǰϵͳĬ�ϵ��ַ������ַ�������ת��
		 * Ϊ��Ӧ��һ���ֽڡ�
		 * 
		 * GBK:������룬Ӣ��1���ֽڣ�����2���ֽ�
		 * GB2312:��������
		 * UTF-8:����룬�䳤���뼯
		 *       Ӣ��1���ֽڣ�����3���ֽ�
		 * ISO8859-1:һ��ŷ�޵ı��뼯����֧������
		 * 
		 */
//		byte[] data = str.getBytes();
		/*
		 * byte[] getBytes(String charsetName)
		 * ���ݸ������ַ�������ǰ�ַ�������ת��Ϊ
		 * һ���ֽ�
		 * �ַ������Ʋ����ִ�Сд�����ǽ����д��
		 */
		byte[] data = str.getBytes("UTF-8");
		
		raf.write(data);
		
		//��ָ���ƶ����ļ����ʼ�ĵ�һ���ֽ���
		raf.seek(0);
		
		/*
		 * ��ȡ�ַ�������
		 */
		byte[] buf = new byte[50];
		int len = raf.read(buf);
		System.out.println(len);//31
		/*
		 * String�Ĺ��췽����
		 * String(byte[] d)
		 * ���յ�ǰϵͳĬ�ϵ��ַ��������������ֽ�
		 * �����е������ֽ�ת��Ϊ��Ӧ��һ���ַ���
		 * 
		 * String(byte[] d,String charsetName)
		 * ���ո������ַ������������ֽ������е�����
		 * �ֽ�ת��Ϊһ���ַ���
		 * 
		 * String(byte[] d,int offset,
		 *        int len,String charsetName)
		 * ���������ֽ������д�offset����ʼ������len���ֽ�
		 * �Ը������ַ�������ת��Ϊһ���ַ���
		 */
		String str1 = new String(buf,0,len,"UTF-8");
		System.out.println(str1);
		raf.close();
	}
}












