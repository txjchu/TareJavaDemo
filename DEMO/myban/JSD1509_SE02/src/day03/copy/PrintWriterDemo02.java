package day03.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * ��Ϊ�߼������д���������
 * PrintWriter�ṩ�Ĺ��췽���������Ǵ����ַ�����Ҳ���Դ����ֽ�����
 * ����ֱ�Ӱ�װ�ֽ����ı׶��ǲ���ָ���ַ�����
 * 
 * �������Ϸ�ʽ������PrintWriter�����Զ���ˢ�¹��ܡ�
 * @author Administrator
 *
 */
public class PrintWriterDemo02 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("pw.txt");
		/*
		 * ֱ�Ӱ�װ�ֽ���������ָ���ַ���
		 */
//		PrintWriter pw = new PrintWriter(fos);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		PrintWriter pw = new PrintWriter(osw);
		pw.println("�Ұ�ĳĳ����ʦ");
		pw.close();
		
	}
}














