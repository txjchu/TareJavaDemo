package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���������д�����ݵ�ע������
 * @author Administrator
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("bos.txt");
		
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		
		String str = "�Ұ������찲��";
		byte[] data = str.getBytes("UTF-8");
		/*
		 * ��������write����Ҳ���Ὣ�������ֽ�
		 * ����д�������Ǵ����ڲ�������(�ֽ�����)
		 * ֻ�л��������ˣ��Ż�һ����д����
		 */
		bos.write(data);
		/*
		 * ��������Ҫ���ڻ������е�����һ����д��
		 * ʱ�����Ե���flush���÷����Ƚ�ǿ�ƣ��Ὣ
		 * �����������е�����һ����д����
		 * ��Ҫ֪����Ƶ���ĵ��ø÷��������д��������
		 * ����д��Ч�ʣ����Ǵ�����Ч����д���ļ�ʱ��
		 * ����ˡ�
		 */
		bos.flush();
		//�ر�ǰ���Զ�����һ��flush
		bos.close();
	}
}









