package day03.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * �����ַ����������ص㣺����Ϊ��λ��ȡ�ַ�����
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		//���������ַ�����������
		//����ԭ���ϵ��������ֽ���ʽ��ȡ
		FileInputStream fis = new FileInputStream("src"+ File.separator +"day03"+
										File.separator +"BufferedReaderDemo.java");
		//�����ֽ���ʽת��Ϊ�ַ���ʽ
		InputStreamReader isr = new InputStreamReader(fis);
		//����һ���ַ�����ȡ������
		BufferedReader br = new BufferedReader(isr);
		/*
		 * String  readLine()
		 * �����ַ����������ĸ÷�����������ȡ���ɸ��ַ���ֱ����ȡ�����з�Ϊֹ��Ȼ�󽫻��з�֮ǰ�������ַ�ת��Ϊһ���ַ����󷵻أ�
		 * ������ֵΪnull����˵����ȡ���ļ�ĩβ���д���
		 */
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
		
	}
}











