package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReaderת���ַ���
 * 1.���Խ��ֽ���ת��Ϊ�ַ���
 * 2.��������ת�����ַ���
 * @author Administrator
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
					//���뼯������Ҫ������������������ȷ��ȡ����������ݡ�
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//��װ�ֽ����������ñ��뼯
		int c = -1;//����read�����ĳ�ʼֵ
		while((c = isr.read()) != -1){
			System.out.print((char)c);//���Ϊchar����
		}
		isr.close();//�ر���
	}
}












