package day02.Exercise;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import day02.case02.Emp;

/**
 * �κ�ϰ����ϰ
 * @author Administrator
 *
 */
public class TestExercise {
	
	@Test//ϰ��3	�����Զ���Ļ�������д����--ʹ���ֽ��������ʽ�ƶ��ļ�
	public void testMoveFile1() throws IOException{
		//�����ļ���������ļ�����������
		FileInputStream fis = new FileInputStream("fos.dat");
		FileOutputStream fos = new FileOutputStream("src" +File.separator+ "fos_move.dat");
		int len = -1;
		byte[] buf = new byte[32];
		while((len = fis.read(buf)) != -1){
			fos.write(buf, 0, len);//ʹ��3����������ֹ��ȡ���ļ�ĩβ��д�����Ŀ��ֽڡ�
		}
		System.out.println("�ļ��ƶ���ϣ�");
		fis.close();
		fos.close();
	}
	
	@Test//ϰ��4	ʹ�û����ֽ��������ļ����ƶ�
	public void testMoveFile2() throws IOException{
		//�������������������������
		FileInputStream fis = new FileInputStream("fos.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("src"+ File.separator +"bfos_copy.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int a = -1;
		while((a = bis.read()) != -1){
			bos.write(a);//д��a
		}
		System.out.println("�ļ��ƶ����2��");
		bis.close();
		bos.close();
	}
	
	@Test//ϰ��5	���Զ�������д�����������л�����
	public void testWriter() throws IOException{
		//���������ֽ������
		FileOutputStream fos = new FileOutputStream("empList.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		List<Emp> emps = new ArrayList<Emp>();
		emps.add(new Emp("����", 22, "��", 3333.33));
		emps.add(new Emp("����", 23, "Ů", 4444.55));
		emps.add(new Emp("����", 24, "��", 5555.22));
		emps.add(new Emp("����", 25, "Ů", 4333.44));
		oos.writeObject(emps);//���������л�
		System.out.println("����д����ϣ����л����!");
		oos.close();
	}
	@Test//�����л�
	public void testReader() throws IOException, ClassNotFoundException{
		//���������ֽ�������
		FileInputStream fis = new FileInputStream("empList.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		int a = -1;
		List<Emp> emps = (List)ois.readObject();//�����л�
		for(Emp e : emps){
			System.out.println(e);
		}
		System.out.println("�����л���ϣ�����������ϣ�");
		ois.close();
	}
	
}











