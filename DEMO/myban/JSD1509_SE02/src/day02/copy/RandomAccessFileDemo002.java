package day02.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ��ȡ��д���ļ�����ȡָ��λ��
 * @author Administrator
 *
 */
public class RandomAccessFileDemo002 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
		raf.setLength(0);
		System.out.println("length:"+ raf.length());
		long pos = raf.getFilePointer();//��ȡ��ǰָ���±�
		System.out.println("pos:"+ pos);//pos:0
		
		int max = Integer.MAX_VALUE;//int���ֵ
		raf.write(max >>> 24);
		System.out.println("pos:"+ raf.getFilePointer());//pos:1
		raf.write(max >>> 16);
		raf.write(max >>> 8);
		System.out.println("pos:"+ raf.getFilePointer());//pos:3
		raf.write(max);			    //����д���ĴΣ����ܰ�4�ֽڵ�int������д��
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		
		raf.writeInt(max);
		raf.writeLong(123L);//д��Lֵ		8�ֽ�
		System.out.println("pos:"+ raf.getFilePointer());//pos:12
		raf.writeDouble(123.123);//д��double���͵���	8�ֽ�
		System.out.println("pos:"+ raf.getFilePointer());//pos:20
		
		raf.seek(0);//ָ����λ���ļ���ͷ
		System.out.println("pos:"+ raf.getFilePointer());//pos:0
		int i = raf.readInt();//ֱ�Ӷ�ȡint��
		System.out.println(i);//2147483647
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		System.out.println("���ֽڣ�"+ raf.length());//���ֽڣ�24
		raf.seek(16);//ֱ�Ӷ�ȡdouble		int = 4�ֽڣ� long = 8�ֽ�
		double d = raf.readDouble();
		System.out.println(d);//123.123
		System.out.println("pos:"+ raf.getFilePointer());//pos:24
		raf.close();
	}
}
















