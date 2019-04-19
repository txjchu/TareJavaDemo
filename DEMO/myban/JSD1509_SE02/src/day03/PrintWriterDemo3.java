package day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * �Զ���ˢ��
 * ÿ������println����д��һ���ַ������ݺ󣬾ͻ��Զ�����flush��
 * �������������д���ļ�ʱ�ԣ����ǻή��д��Ч�ʡ�
 * 
 * 
 * @author Administrator
 *
 */
public class PrintWriterDemo3 {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner scanner = new Scanner(System.in);	//��������
		
		FileOutputStream fos
			= new FileOutputStream("note.txt");
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		/*
		 * ������PrintWriterʱ������һ�������������һ����(�����ֽڻ����ַ�������)��
		 * ��ô��֧��һ�����ع��췽����������ڶ����������ò�����һ��booleanֵ��
		 * ��ֵΪtrue,�򴴽�������PrintWriter�����Զ���ˢ�¹��ܡ�
		 */
		PrintWriter pw = new PrintWriter(osw,true);
		
		String line=null;
		while(true){
			line = scanner.nextLine();
			if("exit".equals(line)){
				break;
			}
			pw.println(line);
			
		}
		System.out.println("�ټ���");
		pw.close();
	}
}
