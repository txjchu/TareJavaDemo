package day01.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �����ļ�  
 * ��дӲ����Ч�ʱȽϵͣ������Ǵ�Ӳ�̡������ȡ��д�����ݡ�
 * ���ԣ�һ�ζ�дһ���ֽڣ����ɻ���߶�д�Ĵ����������˶�д��Ч�ʡ�Ϊ�����Ч�ʣ����ǿ���ͨ������һ�ζ�д����������
 * �����ٶ�д�Ĵ������ﵽ��߶�д��Ч�ʡ�
 * @author Administrator
 *
 */
public class CopyDemo01 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("scrt.exe", "r");//ԭ������Դ
		RandomAccessFile desc = new RandomAccessFile("scrt_copy.exe", "rw");
		RandomAccessFile r = new RandomAccessFile("r.txt" , "rw");
		int d = -1;
		long start = System.currentTimeMillis();//��ȥ��ǰʱ���ĺ�����
		while((d = src.read()) != -1){//ֻҪû�ж�ȡ���ļ�ĩβ
//			desc.write(d);//д���src�ж�ȡ����int��
		}
		long end = System.currentTimeMillis();
		System.out.println("������ϣ���ʱ��"+ (end - start));
		
		r.close();
		src.close();
		desc.close();
	}
}

















