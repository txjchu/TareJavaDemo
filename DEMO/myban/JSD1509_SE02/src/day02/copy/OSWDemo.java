package day02.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter����ַ�ת����
 * @author Administrator
 *
 */
public class OSWDemo {	
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//�����ַ���
		osw.write("�Ұ������찲�ţ�");
		osw.write("Ħ��Ħ����ħ��Ĳ�����");
		osw.write("һ��������");
		osw.write("���ָ�������硣");
		osw.close();
		
	}
}












