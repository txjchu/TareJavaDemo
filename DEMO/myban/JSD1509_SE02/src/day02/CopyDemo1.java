package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ���ļ�������ļ����Ʋ���
 * 
 * �ļ�����RandomAccessFile(RAF)������
 * 1.RAF���ļ�ͬʱ���Խ��ж�д���������������У�
 * 	 ��ȡֻ��ʹ����������д��ֻ��ʹ���������
 * 2.RAF���Ը���ָ����ʽ��д�ļ����ݣ�����ֻҪָ��λ�ã��������ض�д����λ���ϵ����ݣ�
 * 	 ���������У�����ȡ���ݺ��ǲ����ٻص�֮ǰ���¶��ģ����Ǵ����µ�����д��Ҳ��һ����
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("inst.exe");
		FileOutputStream fos
			= new FileOutputStream("inst_copy2.exe");
		
		byte [] buf= new byte[1024*10];
		int len=-1;
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		System.out.println("������ϣ�");
		fis.close();
		fos.close();
//		byte[] data=new byte[60];
//		int len=foa.read(data);
//		String str=new String(data,0,len,"GBK");
		
		
		
	}
}
