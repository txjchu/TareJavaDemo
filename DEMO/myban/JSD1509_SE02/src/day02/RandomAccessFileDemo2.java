package day02;

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
		RandomAccessFile raf
			= new RandomAccessFile("test.dat","rw");
		
		/*
		 * RAF�ǻ���ָ����ж�д�����ģ�
		 * ������ָ�뵱ǰλ�ý��ж�д�ֽڣ�ÿ�������������д��ָ����Զ�����ƶ���
		 * �մ����õ�RAFָ��Ĭ��λ����0������ָ���ļ��ĵ�һ���ֽڡ�
		 * 
		 * long getFilePointer()
		 * ��ȡָ�뵱ǰλ�á�
		 */
		long pos=raf.getFilePointer();
		System.out.println("ָ�뵱ǰλ��pos��"+pos);
//		System.out.println("ָ�뵱ǰλ��pos��"+raf.getFilePointer());
		
		//��int���ֵд��
		int max= Integer.MAX_VALUE;
		/*
		 * Ҫ����д��4���ֽڲſ��Խ�intֵд��
		 * 01111111 11111111 11111111 11111111
		 * 
		 */
		
		raf.write(max>>>24);		//1
		raf.write(max>>>16);		//1
		raf.write(max>>>8);			//1
		raf.write(max);				//1
		
		//����д��4���ֽڣ���intֵд��
		/*
		 * int readInt()
		 * �÷�����������ȡ4���ֽڣ���ת��Ϊintֵ���ء�
		 * ���ڲ�������������-1��ʾ��ȡ���ļ�ĩβ�����Ը÷�������ȡ��ĩβ���׳�
		 * һ���쳣EOFException		EOF(end of file)
		 */
		
		raf.writeInt(max);			//4
		System.out.println("ָ�뵱ǰλ��pos��"+raf.getFilePointer());//8
		raf.writeLong(123L);		//8
		raf.writeDouble(123.123);	//8
		
		//ֱ�Ӷ�ȡdouble
		raf.seek(16);
		double d=raf.readDouble();
		System.out.println(d);
		System.out.println("ָ�뵱ǰλ��pos��"+raf.getFilePointer());
		System.out.println(raf.length());
		raf.close();
		
	}
}
