package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * ����ָ�����ʽ��д�ļ����ݡ�
 * 
 * ����RandomAccessFile�����ֳ���ģʽ:
 * ֻ��ģʽ�Ͷ�дģʽ��
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���ļ�demo.dat��д������
		 * 
		 * ����д���ݵĲ�������ô����ʱҪʹ��
		 * ��дģʽ���ڶ�������Ϊ"rw".
		 */
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.dat","rw"
			);
		
		/*
		 * void write(int i)
		 * ���ļ���д��1���ֽڵ�2��������
		 * д�����Ǹ�����intֵת��Ϊ��2�����е�
		 * "�Ͱ�λ"
		 *                            vvvvvvvv
		 * 00000000 00000000 00000000 00001010
		 */
		raf.write(10);
		/*
		 * ��д��Ϻ�һ��Ҫ����close()����
		 * �رգ����ͷ���Դ
		 */
		raf.close();
		
		
	}
}










