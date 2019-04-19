package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile�ṩ��������д���ݵķ���
 * 
 * int read(byte[] data)
 * �÷�����һ�γ��Զ�ȡ�������ֽ�����data���ܳ��ȵ��ֽ�����
 * ������ȡ����������װ�뵽�������У�����ֵΪʵ�ʶ�ȡ�����ֽ�����
 * ������ֵΪ-1�����ʾi���û�ж�ȡ���κ����ݣ��ļ�ĩβ�ˣ���
 * 
 * void write(byte[] data)
 * һ���Խ��������ֽ������е������ֽ�ȫ��д����
 * 
 * void write(byte[] data,int offset,int len)
 * һ���Խ��������ֽ������д�offset����ʼ����len ���ֽ�д����
 * ��д���ֽ������еĲ������ݣ�
 * 
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src 
			= new RandomAccessFile("inst.exe", "r");
		RandomAccessFile desc
			= new RandomAccessFile("inst_copy.exe","rw");
		
		int len=-1;
		byte[] data=new byte[1024*10];
		long start = System.currentTimeMillis();
		while((len=src.read(data))!=-1){
			desc.write(data,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("������ϣ�����ʱ��"+(end-start));
		
		src.close();
		desc.close();
	}
}
