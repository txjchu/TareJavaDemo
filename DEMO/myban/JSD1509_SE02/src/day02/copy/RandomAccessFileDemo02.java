package day02.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��д������������
 * @author Administrator
 *
 */
public class RandomAccessFileDemo02 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
		/*
		 * RAF�ǻ���ָ����ж�д�����ģ�
		 * ������ָ�뵱ǰλ�ý��ж�д�ֽڣ�ÿ�����������д��ָ����Զ�����ƶ���
		 * �մ����õ�RAFָ��Ĭ��λ��Ϊ0������ָ���ļ��ĵ�һ���ֽڡ�
		 * long  getFilePointer()
		 * ��ȡ��ǰָ��λ��
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:"+ pos);//pos:0
		//��int ���ֵд��
		int max = Integer.MAX_VALUE;
		/*
		 * Ҫ����д��4���ֽڲſ��Խ�intֵд����(int����������4�ֽڣ�32λ������)
		 * 00000000 00000000 01111111 11111111 11111111 11111111
		 * 												^^^^^^^^
		 * void  write(int d)
		 * �ڵ�ǰָ��λ�ÿ�ʼд��һ���ֽڡ�int��4�ֽڣ����Ը÷���ֻд����int�ĵͰ�λ��
		 */
		raf.write(max >>> 24);//��max ������λ24λ����ֻд�������8λ���߰�λ��
		System.out.println("pos:"+ raf.getFilePointer());//pos:1
		raf.write(max >>> 16);
		raf.write(max >>> 8);
		System.out.println("pos:"+ raf.getFilePointer());//pos:3
		raf.write(max);		 //ÿ��ֻд��int�ĵͰ�λ������д��4�Σ���intֵȫ��д�롣
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		
		raf.writeDouble(123.123);//double���͵�����8�ֽ�
		System.out.println("pos:"+ raf.getFilePointer());//pos:12
		
		/*
		 * int readInt()
		 * �÷�����������ȡ4���ֽڣ���ת��Ϊintֵ���ء����ڲ�������������-1��ʾ��ȡ���ļ�ĩβ��
		 * ���Ը÷�������ȡ��ĩβ���׳�һ���쳣EOFException(EOF: end of file).
		 */
		raf.seek(0);//ָ����λ������λ��
		System.out.println("pos:"+ raf.getFilePointer());//pos:0
		int i = raf.readInt();
		System.out.println(i);//2147483647
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		raf.close();
	}
}














