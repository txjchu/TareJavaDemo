package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��д������������
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"test.dat","rw"	
			);
		/*
		 * RAF�ǻ���ָ����ж�д������:
		 * ������ָ�뵱ǰλ�ý��ж�д�ֽڣ�ÿ������
		 * �������д��ָ����Զ�����ƶ���
		 * �մ����õ�RAFָ��Ĭ��λ��Ϊ0,����ָ��
		 * �ļ��ĵ�һ���ֽڡ�
		 * long getFilePointer()
		 * ��ȡ��ǰָ��λ��
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:"+pos);//0
		
		
		//��int���ֵд��
		int max = Integer.MAX_VALUE;
		/*
		 * Ҫ����д��4���ֽڲſ��Խ�intֵд��
		 *                            vvvvvvvv
		 * 00000000 00000000 01111111 11111111 11111111 11111111
		 */
		raf.write(max>>>24);
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.write(max>>>16);
		raf.write(max>>>8);
		raf.write(max);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		//����д��4���ֽڣ���intֵд��
		raf.writeInt(max);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.writeLong(123L);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.writeDouble(123.123);
		System.out.println("pos:"+raf.getFilePointer());
		
		/*
		 * int readInt()
		 * �÷�����������ȡ4���ֽڣ���ת��Ϊint
		 * ֵ���ء����ڲ�������������-1��ʾ��ȡ��
		 * �ļ�ĩβ�����Ը÷�������ȡ��ĩβ���׳�
		 * һ���쳣EOFException
		 * EOF(end of file)
		 * 
		 */
		raf.seek(0);
		System.out.println("pos:"+raf.getFilePointer());
		int i = raf.readInt();
		System.out.println(i);
		System.out.println("pos:"+raf.getFilePointer());
		
		//ֱ�Ӷ�double
		raf.seek(16);
		double d = raf.readDouble();
		System.out.println(d);
		System.out.println("pos:"+raf.getFilePointer());
		raf.close();
	}
}









