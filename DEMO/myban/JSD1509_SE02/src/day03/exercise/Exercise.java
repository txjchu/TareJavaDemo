package day03.exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * �κ�ϰ����ϰ
 * @author Administrator
 *
 */
public class Exercise {
	
	@Test//ϰ��1	����Br��Pw�ַ����������
	public void testBrAndPw() throws IOException{
		
		FileInputStream fis = new FileInputStream("pw.txt");
		InputStreamReader isr = new InputStreamReader(fis, "GBK");//�ֽ���ת��Ϊ�ַ���
		BufferedReader br = new BufferedReader(isr);//�����ַ�������
		
		FileOutputStream fos = new FileOutputStream("pw.txt", true);//׷��ģʽ
//		FileOutputStream fos = new FileOutputStream("pw.txt");//��дģʽ
		OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
		PrintWriter pw = new PrintWriter(osw, true);//�����ַ������
		String str = "";
		String all = "";
		while((str = br.readLine()) != null){
			all += str;
			System.out.println(all);
		}
		pw.println();//����
		pw.println(all);
		System.out.println("������ɣ�");
		br.close();
		pw.close();
	}
}
