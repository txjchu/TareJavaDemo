package day03.case03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

import org.junit.Test;

/**
 * ����
 * @author Administrator
 *
 */
public class Case03 {
	
	@Test//����1	д���ı�
	public void testPW() throws IOException{
		PrintWriter  pw = new PrintWriter("pw.txt");
		pw.println("��Һã�");
		pw.println("hello,");
		pw.println("bye");
		pw.close();
	}
	
	@Test//����2	ʹ���ַ���������ȡ�ļ�
	public void testBR() throws IOException{
		FileInputStream fis = new FileInputStream("pw.txt");//�ֽ�������
		InputStreamReader isr = new InputStreamReader(fis, "GBK");//���ֽ���ת��Ϊ�ַ���
		BufferedReader br = new BufferedReader(isr);//�����ַ�������
//		int len = -1;
//		while((len = br.read()) != -1){
//			System.out.print((char)len);//���ֽڴ�ӡ
//		}		
		//���д�ӡ
		String str = null;
		while((str = br.readLine()) != null){
			System.out.println(str);
		}
	}
	
	@Test//����4	���Գ������쳣
	public void testException(){
//		String str = null;
//		System.out.println(str.length());//NullPointerException
//		int[] arr = new int[2];
//		System.out.println(arr[2]);//ArrayIndexOfBoundsException
//		System.out.println(5 / 0);//ArithmeticException
		
//		Object obj = "hello";
//		Integer i = (Integer)obj;//ClassCastException
//		System.out.println(i);
		String str = "һ����";
		int a = Integer.parseInt(str);//NumberFormatException
		System.out.println(a);
	}
	
}









