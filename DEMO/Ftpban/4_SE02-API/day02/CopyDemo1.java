package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ���ļ�������ļ����Ʋ���
 * 
 * �ļ�����RandomAccessFile������
 * 1:RAF���ļ�ͬʱ���Խ��ж�д���������������У�
 *   ��ȡֻ��ʹ����������д��ֻ��ʹ���������
 * 2:RAF���Ը���ָ����ʽ��д�ļ����ݣ�����ֻҪָ��
 *   λ�ã��������ض�д����λ���ϵ����ݡ����������У�
 *   ����ȡ���ݺ��ǲ����ٻص�֮ǰ���¶��ģ����Ǵ���
 *   �µ�����д��Ҳ��һ���ġ�
 *     
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"scrt.exe"	
			);
		
		FileOutputStream fos
			= new FileOutputStream(
				"scrt_copy2.exe"	
			);
		
		byte[] buf = new byte[1024*10];
		int len = -1;
		while((len = fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		System.out.println("�������");
		fis.close();
		fos.close();
	}
}








