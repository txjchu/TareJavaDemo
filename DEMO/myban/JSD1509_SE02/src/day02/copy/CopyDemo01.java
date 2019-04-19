package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ�����RandomAccessFile������
 * 1.RAF���ļ�ͬʱ���Խ��ж�д���������������У���ȡֻ��ʹ��������InputStream��д��ֻ���������OutputStream��
 * 2.RAF���Ը���ָ����ʽ��д�ļ����ݣ�����ֻҪָ��λ�ã��������ض�д����λ���ϵ����ݡ�
 *   ���������У�����ȡ���ݺ��ǲ����ٻص�֮ǰ���¶��ģ�û�в���ָ��ķ��������Ǵ����µ�����д��Ҳ��һ����
 * @author Administrator
 *
 */
public class CopyDemo01 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("scrt.exe");
		FileOutputStream fos = new FileOutputStream("scrt_copy2.exe");
		byte[] buf = new byte[1024 * 10];//ÿ�ζ�д10KB
		int len = -1;
		while((len = fis.read(buf)) != -1){//��û�ж�ȡ���ļ�ĩβ
			fos.write(buf, 0, len);
		}
		System.out.println("������ϣ�");
		fis.close();
		fos.close();
	}
}
















