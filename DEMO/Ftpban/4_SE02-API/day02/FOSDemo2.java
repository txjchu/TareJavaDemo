package day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ׷��д�������ļ��ֽ������
 * @author Administrator
 *
 */
public class FOSDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���ع��췽����������ڶ�����������һ��
		 * booleanֵ������ֵΪtrue������׷��д����
		 * ��ôͨ������д�������ݻ�׷���ڸ��ļ�ĩβ��
		 */
		FileOutputStream fos
			= new FileOutputStream(
				"fos.txt",true	
			);
		
		String str = "Ħ��Ħ��.";
		
		byte[] data = str.getBytes("GBK");
		fos.write(data);
		
		fos.close();
	}
}





