package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * ׷��д�������ļ��ֽ������
 * @author Administrator
 *
 */
public class FOSDemo02 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���ع��췽����������ڶ�����������һ��booleanֵ������ֵΪtrue������׷��д������
		 * ��ôͨ������д�������ݻ�׷���ڸ��ļ�ĩβ��
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt", true);
		String str = "Ħ��Ħ��.";
		byte[] data = str.getBytes("GBK");//���ַ���ת��Ϊbyte����
		fos.write(data);
		
		FileInputStream fis = new FileInputStream("fos.txt");
		data = new byte[100];
		int len = fis.read(data);//���ֽڶ�ȡ�����Զ�������byte�������������ϵ����ݣ�����ÿ���ֽڵĵײ�2�����롣
		//��byte[]����ת��ΪString�����Բ���String(byte[] b, int offset, int len, String charsetName)�Ĺ��췽��
		String s = new 	String(data, 0, len, "GBK");
		System.out.println(s);
		
		fis.close();
		fos.close();
	}
}










