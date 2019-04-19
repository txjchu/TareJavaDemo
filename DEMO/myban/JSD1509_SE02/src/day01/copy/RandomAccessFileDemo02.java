package day01.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ȡ�ļ�����
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo02 {
	public static void main(String[] args) throws IOException {
		/*
		 * ����ֻ��ģʽ������������дģʽҲ��Ӱ���ȡ��
		 */
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		/*
		 * int  read()
		 * ��ȡ1���ֽڣ�����int��ʽ���أ����Ǹ�intֵ��2������Ϣֻ�С��Ͱ�λ�������ݡ�
		 * ������intֵ��ʾ����-1,���ʾ��ȡ�����ļ�ĩβ��1���ֽڵ�2��������������int��-1�ġ���
		 * 00000000 00000000 00000000 00001010
		 * 11111111 11111111 11111111 11111111
		 */
		int d = raf.read();
		System.out.println(d);//10
		System.out.println(raf.read());//-1
		long l = raf.getFilePointer();
		System.out.println("ָ�����ڵ�λ�ã�"+ l);//1
		System.out.println("�ļ���СΪ��"+ raf.length());
		
		File file = new File("demo.dat");
		System.out.println(file.length());
		File file1 = new File("demo.txt");				//һ��Ӣ����ĸ1���ֽڣ�һ������2���ֽ�
		System.out.println("demo.txt�Ĵ�СΪ��"+ file1.length());//demo.txt�Ĵ�С
		RandomAccessFile raf1 = new RandomAccessFile("demo.txt", "r");
		while(raf1.read() != -1){
			raf1.read();
		}
		System.out.println("demo.txt��ȡ���");			
		System.out.println("demo.txt�ļ��е�ָ��λ�ã�"+ raf1.getFilePointer());
		
		raf1.close();
		raf.close();
	}
}












