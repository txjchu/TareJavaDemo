package day03.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * java.io.PrintWriter
 * �����Զ���ˢ�¹��ܵĻ����ַ������
 * 
 * PrintWriter�ڴ���ʱ�ڲ����Զ���װһ�㡣
 * BufferedWriter��Ϊ���幦�ܣ��������־߱��Զ���ˢ�£�����ʵ�ʿ�����Ҳ�Ƚϳ��á�
 * @author Administrator
 *
 */
public class PrintWriterDemo01 {
	public static void main(String[] args) throws IOException, IOException {
		/*
		 * ֱ�����ļ�����д�����Ĺ��췽��
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 * 
		 */
		PrintWriter pw = new PrintWriter("pw.txt", "UTF-8");
		pw.println("Ħ��Ħ��");
		pw.println("��ħ��Ĳ���");
		pw.print("������������");
		pw.print("�ǹ㳡�����");
		pw.close();
	}
}














