package day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io.ObjectOutputStream
 * �߼����������ǿ��Խ��κ�java����ת��Ϊһ���ֽ�
 * ��ͨ���䴦�����д����
 * 
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		//��һ���ֽ�д�뵽�ļ���
		FileOutputStream fos
			= new FileOutputStream(
				"person.obj"	
			);
		//�������Ķ���ת��Ϊһ���ֽ�
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		Person p = new Person();
		p.setName("����ʦ");
		p.setAge(30);
		p.setGender("Ů");
		
		List<String> otherInfo
			= new ArrayList<String>();
		otherInfo.add("�Ǹ���Ա");
		otherInfo.add("��дë����");
		otherInfo.add("�ٽ������Ļ�����");
		
		p.setOtherInfo(otherInfo);
		
		System.out.println(p);
		/*
		 * void writeObject(Object obj)
		 * �÷����Ὣ�����Ķ���ת��Ϊһ���ֽڣ�Ȼ��
		 * ͨ���䴦�����д����
		 * ����oos���������fos,���Ը÷�����ת��
		 * ����ֽ�ͨ��fos��д�뵽�ļ����ˡ�
		 * 
		 * ���ֽ�д��Ӳ�̵Ĺ��̳�Ϊ:�־û�
		 */
		oos.writeObject(p);
		
		oos.close();
	}
}









