package day02;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ�û������ӿ��дЧ�ʽ����ļ����Ʋ���
 * 
 * java.io.BufferedOutputStream
 * java.io.BufferedInputStream
 * 
 * �����ֽ��������������һ�Ը߼�����ʹ���������������󣬿��Լӿ��дЧ�ʡ� 
 * 
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("scrt.exe");
		FileOutputStream fos
			= new FileOutputStream("scrt_copy.exe");
		
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		int d=-1;
		/*
		 * ������������  int read()������
		 * �����ڲ�ά��һ�����������ֽ����飩��Ȼ�����ǵ���read������ͼ��ȡһ���ֽ�ʱ��
		 * �÷�������䴦�������һ���Զ�ȡһ���ֽڲ����뻺�����У�
		 * Ȼ�󽫵�һ���ֽڷ��ء�
		 * �������ٴε��ø÷�����ȡ�ֽ�ʱ��������������еڶ����ֽڷ��ء�ֱ���ֽ������е�����
		 * �ֽ�ȫ������ȡ��Ϻ󣬲Ż��ٴ�ͨ���䴦�����һ���Զ�ȡ��һ�����ݡ�
		 * ���� ����������߶�ȡЧ�ʵķ�ʽ��Ȼ�����ÿ�ζ�ȡ���������������˶�ȡ�Ĵ����ﵽ�ġ�
		 */
//		byte[] data=new byte(1024*10);
		while((d=fis.read())!=-1){
			bos.write(d);
		}
		
		System.out.println("�����������");
		/*
		 * �����ǽ������������Ӻ�ʹ�ø߼���������һ������������ʽ�ͳ�Ϊ�������ӡ���
		 * �ر�ʱֻ��Ҫ�ر������ĸ߼������ɡ�
		 * ��Ϊ�߼����ڹر�����ǰ���Ƚ��䴦������رա�
		 */
		fis.close();
		fos.close();
		bos.close();
	}
}
