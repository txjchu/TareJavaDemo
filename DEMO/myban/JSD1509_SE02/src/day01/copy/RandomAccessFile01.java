package day01.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * �����ļ�ָ�����ʽ��д�ļ����ݡ�
 * 
 * ����RandomAccessFile�����ֳ���ģʽ��r:ֻ��ģʽ��rw:�ɶ���дģʽ
 * @author Administrator
 *
 */
public class RandomAccessFile01 {
	public static void main(String[] args) throws InterruptedException, IOException {
		/*
		 * ���ļ�demo.dat��д������
		 * 
		 * ����д���ݵĲ�������ô����ʱҪʹ�ö�дģʽ���ڶ�������Ϊ"rw"��
		 */
		File file = new File("demo.dat");//�����ļ�����
		RandomAccessFile raf = new RandomAccessFile(file, "rw");//������������ļ����󣬲���2�ɶ���д
		/*
		 * void  write(int i)
		 * ���ļ���д��1���ֽڵ�2�������ݣ�д�����Ǹ�����intֵת��Ϊ2�����еġ��Ͱ�λ��
		 * 							  vvvvvvvv
		 * 00000000 00000000 00000000 00001010
		 */
		raf.write(10);
		/*
		 * ��д��Ϻ�һ��Ҫ����close()�����رգ����ͷ���Դ��
		 */
		raf.close();
	}
}










