package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ļ�
 * 
 * ��дӲ����Ч�ʱȽϵͣ������Ǵ�Ӳ�̣������ȡ��
 * д�����ݡ�
 * 
 * ���ԣ�һ�ζ�дһ���ֽڣ����ɻ���߶�д�Ĵ�����
 * �����˶�д��Ч�ʡ�Ϊ�����Ч�ʣ����ǿ���ͨ��
 * ����һ�ζ�д���������������ٶ�д�Ĵ���,�ﵽ
 * ��߶�д��Ч�ʡ�
 * 
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile(
				"scrt.exe","r"
			);		
		RandomAccessFile desc
			= new RandomAccessFile(
				"scrt_copy.exe","rw"
			);
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read())!=-1){
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("�������,��ʱ:"+(end-start));
		src.close();
		desc.close();
	}
}




