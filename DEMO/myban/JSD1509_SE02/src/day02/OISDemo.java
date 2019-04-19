package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream
 * �߼����������ǿ��Զ�ȡһ���ֽڣ�Ȼ���仹ԭΪ��Ӧ�Ķ���(����ķ����л�)��
 * ��Ҫע����ǣ���ȡ����һ���ֽڱ�������
 * ObjectOutputStream��writeObject�������л�����õ��ġ�
 * @author Administrator
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis
			= new FileInputStream("person.obj");
		
		ObjectInputStream ois				//-----�߼��������رո߼����͹ر��˵ͼ�����
			= new ObjectInputStream(fis);
		/*
		 * Object readObject()
		 * �����л�����-------------------����������л��ͷ����л�������ʹjava�ļ�ʵ�ִ浵��
		 */
		Person p=(Person)ois.readObject();
		
		System.out.println(p);
		
		ois.close();
		
	}
}
