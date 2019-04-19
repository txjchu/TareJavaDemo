package day02.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * ��д�ַ���
 * @author Administrator
 *
 */
public class RandomAccessFileDemo01 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");//����raf����
		String str = "Ħ��Ħ������ħ��Ĳ�����";//����״̬�µķ��ţ���UTF-8��Ҳ��3���ֽڡ�
		/*
		 * �ַ����ṩ�˽�����ת��Ϊ��Ӧ�ı���ķ���
		 * byte[]  getBytes()
		 * ���յ�ǰϵͳĬ�ϵ��ַ������ַ�������ת��Ϊ��Ӧ��һ���ֽ����顣
		 * 
		 * GBK:���ʱ��룬Ӣ��1���ֽڣ�����2���ֽڡ�
		 * GB2312:��������
		 * UTF-8:����룬�䳤���뼯��Ӣ��1���ֽڣ�����3���ֽ�
		 * ISO8859-1:һ��ŷ�޵ı��뼯����֧�����ġ�
		 */
//		byte[] date = str.getBytes();
		/*
		 * byte[]  getBytes(String charsetName)
		 * ���ݸ������ַ�������ǰ�ַ�������ת��Ϊһ���ֽ����飬�ַ������Ʋ����ִ�Сд���������д��
		 * 
		 */
		byte[] date = str.getBytes("UTF-8");
		raf.write(date);//д��date
		//��ָ���ƶ����ļ��ʼ�ĵ�һ���ֽ���
		raf.seek(0);
		/*
		 * ��ȡ�ַ���������
		 */
		byte[] buf = new byte[50];
		int len = raf.read(buf);//��ȡraf�ļ��е��ֽڣ�������buf�У�����ʵ�ʶ������ֽ���len
		System.out.println(len);//36
		/*
		 * String �Ĺ��췽��
		 * String(byte[] d)
		 * ���յ�ǰϵͳĬ�ϵ��ַ��������������ֽ������е������ֽ�ת��Ϊ��Ӧ��һ���ַ�����
		 * 
		 * String(byte[] d, String charsetName)
		 * ���ո������ַ������������ֽ������е������ֽ�ת��Ϊһ���ַ�����
		 * 
		 * String(byte[] d, int offset, int len, String charsetName)
		 * ���������ֽ������д�offset����ʼ������len���ֽ��Ը������ַ�������ת��Ϊһ���ַ�����
		 */
		String str1 = new String(buf, 0, len, "UTF-8");
		System.out.println(str1);
		raf.close();
	}
}


















