package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ��ȡ�ļ�����
		 */
		RandomAccessFile raf 
			= new RandomAccessFile("demo.dat","r");
		/*
		 * int read()
		 * ��ȡ1���ֽڣ�����int��ʽ���ء����ǣ���intֵ��2������Ϣֻ�С��Ͱ�λ�������ݡ�
		 * ������intֵ��ʾ����-1�����ʾ��ȡ���ˣ�
		 * �ļ�ĩβ��1���ֽڵ�2��������������int��-1�ġ���
		 */
		int d=raf.read();
		System.out.println(d);
		
		raf.close();
	}
}
