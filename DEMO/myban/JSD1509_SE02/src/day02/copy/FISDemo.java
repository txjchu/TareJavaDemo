package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * �ļ��ֽ�����������һ���ͼ��������Խ����ݴ��ļ���ȡ��java�С�
 * @author Administrator
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] data = new byte[100];
		int len = fis.read(data);//��ȡʵ�ʶ�ȡ�����ֽ���
		String str = new String(data, 0, len, "GBK");
		System.out.println(str);
		fis.close();
	}
}














