package day02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java.io.FileOutputStream
 * �ͼ��������ڽ�����д�����ļ��С�
 * 
 * �̳���java.io.OutputStream
 * 
 * �ͼ����ص�:
 * �����д���ݵ��������ݵ���Դ(in),ȥ��(out)��
 * ��ȷ�ġ�
 *  
 * @author Administrator
 *
 */
public class FOSDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * FileOutputStream(String path)
		 * FileOutputStream(File file)
		 * �������ֹ��췽�������������ļ��ֽ��������
		 * �Ǹ���д��������˼�ǣ���ʹ�������ļ���д
		 * ������ǰ�����Ƚ����ļ���ԭ��������ɾ����
		 * Ȼ���ٰ�ͨ������д��������д����ļ��С�
		 * 
		 */
		FileOutputStream fos
			= new FileOutputStream(
				"fos.txt"
			);
		
		String str = "�ҵĻ���Ь,ʱ��ʱ����ʱ��";
		
		byte[] data = str.getBytes("GBK");
		fos.write(data);
		//��ʹ����Ϻ�Ҫ�ر�
		fos.close();
		
	}
}








