package day03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * �����Զ���ˢ�¹��ܵĻ����ַ������
 * �����ַ������ص��ǿ�������Ϊ��λ��д�ַ�����
 * 
 * PrintWriter�ڴ������ڲ����Զ���װһ��
 * BufferedWriter��Ϊ���幦�ܡ��������־߱�
 * �Զ���ˢ�£�����ʵ�ʿ�����Ҳ�Ƚϳ��á�
 * @author Administrator
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ֱ�����ļ�����д�����Ĺ��췽��
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 */
		PrintWriter pw 
			= new PrintWriter("pw.txt","UTF-8");
		
		pw.println("Ħ��Ħ��");
		pw.println("��ħ��Ĳ���");
		pw.println("������������");
		pw.println("�ǹ㳡�����");
		
		pw.close();
	}
}







