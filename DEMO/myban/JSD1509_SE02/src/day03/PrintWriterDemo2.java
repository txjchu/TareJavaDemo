package day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * ��Ϊ�߼������д���������
 * PrintWriter�ṩ�Ĺ��췽���������Ǵ����ַ�����Ҳ���Դ����ֽ�����-----(�ַ���ֻ�ܰ�װ�ַ�������������������Դ����ֽ���)
 * ����ֱ�Ӱ�װ�ֽ����ı׶��ǲ���ָ���ַ�����
 * 
 * �������Ϸ�ʽ������PrintWriter���С��Զ���ˢ�¡����ܡ�
 * @author Administrator
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream fos				 //�ֽ���
			= new FileOutputStream("pw.txt");
		/*
		 * ֱ�Ӱ�װ�ֽ���������ָ���ַ���
		 */
//		PrintWriter pw						//�ַ���
//			= new PrintWriter(fos);			//����ָ���ַ���
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		//��װ�ַ���
		PrintWriter pw
			= new PrintWriter(osw);
		
		pw.println("�Ұ����ڲ���ʦ!");
		pw.flush();
		pw.close();
		
		
		
		
		
	}
}
