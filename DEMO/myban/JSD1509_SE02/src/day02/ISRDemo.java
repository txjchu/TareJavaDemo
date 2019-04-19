package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * java.io.InputStreamReader
 * �ַ����������ص��ǿ��԰��ո������ַ�����ȡ�ַ���
 * 
 * InputStreamReader��OutputStreamWriter
 * ����Ϊת������
 * 1.���Խ��ֽ���ת��Ϊ�ַ�����
 * 2.����ת���ַ�����
 * 
 * @author Administrator
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("osw.txt");
		
		InputStreamReader isr		//----�ֽ���ת��Ϊ�ַ���
			= new InputStreamReader(fis,"UTF-8");
		
		int d=-1;
		while((d=isr.read())!=-1){
			char c=(char) d;
			System.out.print(c);
		}
		
		isr.close();
	}
}
