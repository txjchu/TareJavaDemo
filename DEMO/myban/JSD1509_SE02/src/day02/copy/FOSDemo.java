package day02.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * java.io.FileOutputStream
 * �ͼ��������ڽ����ݴ�java����Դ��д�����ļ��С�
 * 
 * �̳���java.io.OutputStream
 * 
 * �ͼ����ص㣺�����д���ݵ��������ݵ���Դ��in����ȥ��out������ȷ�ġ�
 * @author Administrator
 *
 */
public class FOSDemo {
	public static void main(String[] args) throws IOException {
		/* 
		 * FileOutputStream(String path)
		 * FileOutputStream(File file)
		 * �������ֹ��췽�������������ļ��ֽ���������Ǹ���д������
		 * ����ʹ�������ļ���д������ǰ�����ȰѸ��ļ���ԭ��������ɾ����Ȼ���ٰ�ͨ������д��������д����ļ��С�
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt");
		String str = "�ҵĻ���Ь��ʱ��ʱ����ʱ��";
		byte[] data = str.getBytes("GBK");
		fos.write(data);//д���ֽ�����
		fos.close();//�ر���
	}
}














