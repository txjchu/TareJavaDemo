package day01.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile�ṩ��������ȡ���ݵķ���
 * 
 * int  read(byte[] data)
 * �÷�����һ�γ��Զ�ȡ�������ֽ�����data���ܳ��ȵ��ֽ�����������ȡ����������װ���������У�
 * ����ֵΪʵ�ʶ�ȡ�����ֽ�����������ֵΪ-1�����ʾ���û�ж�ȡ���κ����ݣ�ָ�뵽�ļ�ĩβ�ˡ���
 * 
 * void  write(byte[] data)
 * һ���Խ��������ֽ������е������ֽ�ȫ��д����
 * 
 * void write(byte[] data, int offset, int len)
 * һ���Խ��������ֽ������д�offset����ʼ����len���ֽ�д������д���ֽ������еĲ������ݣ�
 * @author Administrator
 *
 */
public class CopyDemo02 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("scrt.exe", "r");
		RandomAccessFile desc = new RandomAccessFile("scrt_copy.exe", "rw");
		//ÿ��ʵ�ʶ�ȡ�����ֽ���
		int len = -1;
		//����һ��10k���ֽ�����					1�ֽ� = 8λ2����
		byte[] data = new byte[1024 * 100];//10240��byte������ = 1024 * 10 ���ֽ�
		long start = System.currentTimeMillis();//��ȡ����ʱ���ĺ�����
		while((len = src.read(data)) != -1){//ֻҪ���û�е��ļ�ĩβ
			desc.write(data, 0, len);
		}
		long end = System.currentTimeMillis();//��ȡ����ʱ���ĺ�����
		System.out.println("������ϣ���ʱ��"+ (end - start));//������ϣ���ʱ��278
									//1024 * 100   ��ʱ
		src.close();
		desc.close();
	}
}













