package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ȡ�ļ�����
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ����ֻ��ģʽ������������дģʽҲ��Ӱ��
		 * ��ȡ��
		 */
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.dat","r"	
			);
		
		/*
		 * int read()
		 * ��ȡ1���ֽڣ�����int��ʽ���ء�����
		 * ��intֵ��2������Ϣֻ��"�Ͱ�λ"�����ݡ�
		 * ������intֵ��ʾ����-1,���ʾ��ȡ����
		 * �ļ�ĩβ(1���ֽڵ�2��������������int��-1
		 * �ġ�)
		 * 00000000 00000000 00000000 00001010
		 * 11111111 11111111 11111111 11111111
		 */
		int d = raf.read();
		System.out.println(d);
		
		raf.close();
	}
}	






