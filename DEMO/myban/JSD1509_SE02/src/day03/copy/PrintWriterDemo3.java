package day03.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * �Զ���ˢ��
 * ÿ������println����д��һ���ַ������ݺ󣬾ͻ��Զ�����flush��
 * �������������д���ļ�ʱ�ԣ����ǻή��д��Ч�ʡ�
 * @author Administrator
 *
 */
public class PrintWriterDemo3 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		FileOutputStream fos = new FileOutputStream("note.txt");//�ֽ������
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//���ֽ����ת��Ϊ�ַ��������
		/*
		 * ������PrintWriterʱ������һ�������������һ�����������ֽڻ����ַ������ɣ�����ô��֧��һ�����ع��췽����
		 * ������ڶ����������ò�����booleanֵ����Ϊtrue���򴴽�������PW�����Զ���ˢ�¹��ܡ�
		 */
		PrintWriter pw = new PrintWriter(osw, true);
		String line = null;
		while(true){
			line = scan.nextLine();//�����û�����
			if("exit".equals(line)){
				break;
			}
			pw.println(line);
		}
		System.out.println("�ټ���");
		pw.close();
	}
}
















