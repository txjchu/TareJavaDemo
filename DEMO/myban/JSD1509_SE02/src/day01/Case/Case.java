package day01.Case;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * ������ϰ
 * @author Administrator
 *
 */
public class Case {
	
	
	@Test//����1		�����ǰĿ¼�µ������ļ�
	public void testFile(){
		File dir = new File(".");//�趨·��Ϊ��ǰĿ¼
		File[] files = dir.listFiles();
		for(File file : files){
			System.out.println(file.getName() +" : "+ file);
		}
	}
	
	@Test//����2		�����ǰĿ¼������txt�ļ�
	public void testListfile(){
		File dir = new File(".");
		File[] files = dir.listFiles(new FileFilter(){//�����ļ�ѡ����,������
			@Override
			public boolean accept(File f) {//��дѡ�񷽷�				
				return f.getName().endsWith(".txt");
			}
		});
		for(File file : files){//��ѭ�������ļ�����
			System.out.println(file);
		}
	}
	
	@Test//����3		����raf��read��write����
	public void testRandomAccessFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		/**
		 * ���ݲ���ָ������ļ��ַ������ó����ۣ�
		 * read��write�������ļ�ָ��ᴦ����1���ֽڴ�������
		 */
		//д������1��д�����int���ĵͰ�λ
//		raf.write(new byte[]{0, 1, 2});
		raf.write(1);
//		raf.seek(0);
		System.out.println("��ʱ�������λ�ã�"+ raf.getFilePointer() +"��read��������ֵΪ��"+ raf.read());
		raf.close();
		RandomAccessFile raf1 = new RandomAccessFile("raf.dat", "r");
//		System.out.println(raf1.getFilePointer());
//		int a = raf1.read(), b = raf1.read(), c = raf1.read();		
//		System.out.println("��ʱ���������λ�ã�"+ raf1.getFilePointer() + "��read��ȡ��������:"+ c);//���
		int i = raf1.read();
		System.out.println("��ʱ���������λ�ã�"+ raf1.getFilePointer() + "��read��ȡ��������:"+ raf1.read());
		raf1.close();
	}
	
	@Test//����4		���ֽڶ�ȡ��д�����  
	public void testWriteByteArray() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		byte[] buf = "HelloWorld".getBytes();//���ַ���ת��Ϊbyte����
		raf.write(buf);
		raf.close();
	}
	@Test
	public void testReadByteArray() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		byte[] buf = new byte[10];//����һ��10�ֽڴ�С��byte����
		int len = raf.read(buf);//��ȡbuf��С���ֽڣ�������ʵ�ʶ�ȡ�����ֽ���
		System.out.println(Arrays.toString(buf));//��buf���:[72, 101, 108, 108, 111, 87, 111, 114, 108, 100]
		System.out.println("ʵ�ʶ�ȡ���ˣ�"+ len +"���ֽڣ�"+ new String(buf));//HelloWorld
		raf.close();
	}
	
	@Test//����5		�����ļ�ָ��
	public void testPointer() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		long a = raf.getFilePointer();
		System.out.println("��ǰָ��λ��Ϊ��"+ a);//��ǰָ���λ��Ϊ��0
		int skip = raf.skipBytes(5);//��ָ���������n���ֽ�
		System.out.println("����5���ֽں�ָ��λ��Ϊ��"+ raf.getFilePointer());//����5���ֽں�ָ��λ��Ϊ��5
		byte[] buf = new byte[5];
		int len = raf.read(buf);//��ȡbyte���鳤�ȸ��ֽڣ�����ʵ���������ֽ���
		System.out.println("���ڶ�ȡ��"+ len +"���ֽڣ��������ֽ�Ϊ��"+ new String(buf));//���ڶ�ȡ��5���ֽڣ��������ֽ�Ϊ��World
		raf.seek(0);//��ָ���Ƶ�n�±���
		System.out.println("��ǰָ���λ��Ϊ��"+ raf.getFilePointer());//��ǰָ���λ��Ϊ��0
		raf.close();
	}
	
	
	@Test
	public void testCount(){
		int a = 1;
		int b = a;
		b = b + 1;
		System.out.println(a +","+ b);
		
		int flag = 0;
		for(int i = 0; i < 10; i ++){
			System.out.print(flag +";");//������ڶ���ѭ��ʱ��Ϊʲôflag�ֱ��0��������Ϊv�����棩
			count(flag);
			System.out.println(flag);//��count����ʹ����flag�󣬲�û�н��仯���flag���ظ���ǰ��flag������ʹ�ã����flag����0.
		}
		System.out.println(flag);
	}
	void count(int i){
		i ++;
		System.out.print(i +" ");
	}
}









