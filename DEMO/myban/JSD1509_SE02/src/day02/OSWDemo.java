package day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Writer �����ַ�������ĸ���
 * �ַ������Ǹ߼���
 * �ַ�������������ַ�Ϊ��λд�����ݡ����Ǳ����ϻ���Ҫ���ַ�ת��Ϊ�ֽں�д����
 * 
 * OutputStreamWriter���ص�:
 * ���԰��ո������ַ������ַ���ת��Ϊ�ֽں�д����
 * @author Administrator
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("osw.txt");
		/*
		 * ���ù��췽����
		 * OutputStreamWriter(OutputStream o)
		 * ���������ֽ�����װΪһ���ַ�����Ȼ��ͨ������д�����ַ���
		 * ���ᰴ��ϵͳĬ�ϵ��ַ���ת��Ϊ�ֽں�д����
		 * 
		 * ��Ҫ����ָ�����ַ���д��������ʹ������Ĺ��췽��ָ����
		 */
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		osw.write("Ħ��Ħ��");
		osw.write("һ������");
		osw.write("��ħ��Ĳ���");
		/*
		 * �ر�����Ϊ���ͷ���Դ��
		 * �ͷŵ��ǵײ���Դ����Ӳ�̽���д�������ǵײ��C�⣬����Close��Ŀ�����ͷ�
		 * �ײ���Դ��������ᱻGC�ͷŵġ�
		 * 
		 * 
		 */
		osw.close();
		
		
	}
}
