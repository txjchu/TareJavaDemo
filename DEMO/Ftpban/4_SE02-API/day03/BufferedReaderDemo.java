package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * �����ַ����������ص�:����Ϊ��λ��ȡ�ַ���
 * 
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * ����ǰԴ�������ݶ�ȡ�����������
		 * ����̨��
		 */
		//������ļ��ж�ȡ�ֽ�
		FileInputStream fis
			= new FileInputStream(
				"src"+File.separator+
				"day03"+File.separator+
				"BufferedReaderDemo.java"	
			);
		//�����ֽ�ת��Ϊ�ַ�
		InputStreamReader isr
			= new InputStreamReader(fis);
		//����һ���ַ�����ȡ������
		BufferedReader br
			= new BufferedReader(isr);
		
		/*
		 * String readLine()
		 * �����ַ��������ĸ÷�����������ȡ
		 * ���ɸ��ַ���ֱ����ȡ�����з�Ϊֹ��
		 * Ȼ�󽫻��з�֮ǰ�������ַ�ת��Ϊ
		 * һ���ַ����󷵻ء�������ֵΪnull
		 * ˵��û�����ݿ��Զ�ȡ��(�ļ�ĩβ)
		 */
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
		}
		
		br.close();
	}
}








