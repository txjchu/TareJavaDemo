package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFileDemo1
 * ����ָ�����ʽ��д�ļ����ݡ�
 * 
 * ����RandomAccessFile�����ֳ���ģʽ��
 * ֻ��ģʽ�Ͷ�дģʽ��
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/**
		 * ���ļ�------------------����
		 * ����д���ݵĲ�������ô����ʱҪʹ�ö�дģʽ���ڶ�������Ϊ��rw����
		 */
		RandomAccessFile raf 
			= new RandomAccessFile("demo.dat","rw");//��ǰĿ¼�£���/**/**/**/demo.dat
		/*
		 * void write(int i)
		 * ���ļ���д��1���ֽڵ�2��������
		 * д�����Ǹ�����intֵת��Ϊ2�����еġ��Ͱ�λ��
		 */
		raf.write(10);
		/*
		 * ��д��Ϻ�һ��Ҫ����close���������رգ����ͷ���Դ
		 */		
		raf.close();
		
		
	}
}
