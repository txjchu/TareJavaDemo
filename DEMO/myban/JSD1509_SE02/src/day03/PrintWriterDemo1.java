package day03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * java.io.PrintWriter
 * �����Զ���ˢ�¹��ܵĻ����ַ������
 * �����ַ������ص��ǿ�������Ϊ��λ��д�ַ�����
 * 
 * PrintWriter�ڴ���ʱ�ڲ����Զ���װһ��BufferedWriter��Ϊ���幦�ܡ�
 * �������־߱��Զ���ˢ�£�����ʵ�ʿ�����Ҳ�Ƚϳ��á�
 * @author Administrator
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * ֱ�����ļ�����д�����Ĺ��췽����
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 */
		PrintWriter pw=new PrintWriter("pw.txt");//֧��2��������ָ���ַ��������Լ�"UTF-8"	//---����ֱ�Ӳ����ļ����������е��ַ������Ǹ߼�����
		
		pw.println("Ħ��Ħ��");
		pw.println("��ħ��Ĳ���");
		pw.println("������������");
		pw.println("�ǹ㳡�����");//��52���ֽڣ�4�����з���8���ֽڡ�
		
		pw.close();
		
		
	}
}
