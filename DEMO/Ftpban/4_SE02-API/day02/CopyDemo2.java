package day02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ�û������ӿ��дЧ�ʽ����ļ����Ʋ���
 * 
 * java.io.BufferedOutputStream
 * java.io.BufferedInputStream
 * 
 * �����ֽ��������������һ�Ը߼�����ʹ��������
 * �������󣬿��Լӿ��дЧ��
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"scrt.exe"	
			);
		BufferedInputStream bis
			= new BufferedInputStream(fis);
		
		
		FileOutputStream fos
			= new FileOutputStream(
				"scrt_copy.exe"	
			);
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		int d = -1;
		/*
		 * ������������int read()����:
		 * �����ڲ�ά��һ��������(�ֽ�����)��Ȼ��
		 * �����ǵ���read������ͼ��ȡһ���ֽ�ʱ��
		 * �÷�������䴦�������һ���Զ�ȡһ���ֽ�
		 * �����뻺�����У�Ȼ�󽫵�һ���ֽڷ��ء�
		 * �������ٴε��ø÷�����ȡ�ֽ�ʱ���������
		 * �����еڶ����ֽڷ��ء�ֱ���ֽ������е�����
		 * �ֽ�ȫ������ȡ��Ϻ󣬲Ż��ٴ�ͨ���䴦���
		 * ��һ���Զ�ȡ����һ�����ݡ�
		 * ���ԣ���������߶�ȡЧ�ʵķ�ʽ��Ȼ�����
		 * ÿ�ζ�ȡ���������������˶�ȡ�Ĵ����ﵽ�ġ�
		 * 
		 * 
		 */
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		
		System.out.println("�������");
		/*
		 * �����ǽ������������Ӻ�(ʹ�ø߼���������һ��
		 * ����������ʽ�ͳ�Ϊ��������)
		 * �ر�ʱֻ��Ҫ�ر������ĸ߼������ɡ�
		 * ��Ϊ�߼����ڹر�����ǰ���Ƚ��䴦�����
		 * �رա�
		 */
		bis.close();
		bos.close();
		
		
	}
}











