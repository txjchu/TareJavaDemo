package day02.case02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 * ��������
 * @author Administrator
 *
 */
public class TestCase {
	@Test//����1	����FOS�ĸ���д���׷��д��
	public void testFOS() throws IOException{
		//��дģʽ
		FileOutputStream fos = new FileOutputStream("fos.dat");
		String str = "HelloWorld";
		byte[] b = str.getBytes();//���ַ���ת��Ϊbyte�����飬ÿһ��Ԫ�ؼ�һ��int��ֵ��
		fos.write(b);//д��byte�����ÿһ��Ԫ�أ���д��ÿһ��Intֵ�ĵͰ�λ��������byteֵ��
		//׷��ģʽ
		fos = new FileOutputStream("fos.dat", true);//׷��ģʽ�Ĺ��췽ʽ
		fos.write(b);//׷��д��
		fos.close();
	}
	
	@Test//����2	����FIS��ȡ�ļ�
	public void testFIS() throws IOException{
		FileInputStream fis = new FileInputStream("fos.dat");
		int a = -1;
		while((a = fis.read()) != -1){
			System.out.print((char) a );//���������ֽڰ���char�ַ������
		}
		fis.close();
	}
	
	@Test//����3	����FIS��FOS�е�read()��writer()����ʵ���ļ��ĸ���
	public void testCopyFile1() throws IOException{
		FileInputStream fis = new FileInputStream(new File("fos.dat"));
		FileOutputStream fos = new FileOutputStream("fos_copy1.dat");
		int a = -1;
		while((a = fis.read()) != -1){//û�ж�ȡ���ļ�ĩβ
			fos.write(a);
		}
		System.out.println("�������1��");
		fis.close();
		fos.close();
	}
	@Test
	public void testCopyFile2() throws IOException{
		FileInputStream fis = new FileInputStream("fos.dat");
		FileOutputStream fos = new FileOutputStream(new File("fos_copy2.dat"));
		int a = -1;
		byte[] b = new byte[50];
		while((a = fis.read(b)) != -1){
			fos.write(b);
		}
		System.out.println("�������2��");
		
		fis.close();
		fos.close();
	}
	
	@Test//����4	���Ի��ڻ���ĸ����ļ�����
	public void testBISAndBOS() throws IOException{
		//��������������
		FileInputStream fis = new FileInputStream("fos.dat");
		BufferedInputStream bis = new BufferedInputStream(fis);
		//�������������
		FileOutputStream fos = new FileOutputStream("fos_copy3.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int len = -1;
		while((len = bis.read()) != -1){
			bos.write(len);//ͨ�����淽ʽд��
		}
		System.out.println("�������3��");
		bos.close();
		bis.close();
	}
	
	@Test//����5	���Զ�����OOS��OIS�����л��ͷ����л�
	public void testOOS() throws IOException, Exception{
		//�������������
		FileOutputStream fos = new FileOutputStream("emp.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Emp emp = new Emp("����", 22, "Ů", 2222.2);
		oos.writeObject(emp);
		System.out.println("���л���ϣ���ɳ־û�");
		//��������������
		FileInputStream fis = new FileInputStream("emp.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		if(obj instanceof Emp){
			System.out.println((Emp) obj);
		}
		System.out.println("�����л���ϣ�");
		oos.close();
		ois.close();
	}
	
	@Test//����6	����ָ���ַ���������д���ļ�	
	public void testOSW() throws IOException{
		//�����ַ������
		FileOutputStream fos = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		String str = "Mr��";
		osw.write(str);
		System.out.println("д����ϣ�");
		osw.close();
		
	}
	
	@Test//����7	�����ַ�����������ָ�����뼯��ȡ�ļ��ķ���
	public void testISR() throws IOException{
		//�����ַ�������
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		int len = -1;
		while((len = isr.read()) != -1){
			System.out.print((char)len);//ת��Ϊ�ַ������
		}
		System.out.println("��ȡ��ϣ�");
		isr.close();
	}
}










