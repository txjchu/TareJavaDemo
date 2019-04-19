package day07.exercise;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import day07.copy.Emp;

/**
 * �κ�ϰ��3	�����	---- ���տͻ��˷��͹�����XML����
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8088);
			System.out.println("�ȴ��ͻ�������...");
			Socket socket = server.accept();//�����ͻ�������
			System.out.println("�ͻ��������ӣ�");
			//��ȡ���������������տͻ��˷��͹���������
			InputStream is = socket.getInputStream();
			SAXReader reader = new SAXReader();
			System.out.println("��ʼ��ȡ�ͻ��˷�����������...");
			Document doc = reader.read(is);//����doc���󣬶�ȡ���Ǵӿͻ��˷��͹���������
			//����doc
			Element root = doc.getRootElement();//��ȡ��Ԫ��
			List<Element> list = root.elements();//��ȡ��Ԫ���µ�������Ԫ��
			List<Emp> emps = new ArrayList<Emp>();//���ڴ���xml�е�Ԫ��ת���ɵ�Emp����
			for(Element ele : list){
				String name = ele.element("name").getTextTrim();
				String gender = ele.element("gender").getTextTrim();
				int age = Integer.parseInt(ele.element("age").getTextTrim());
				int salary = Integer.parseInt(ele.element("salary").getTextTrim());
				int id = Integer.parseInt(ele.attribute("id").getValue());//��ȡһ��Ԫ��
				Emp emp = new Emp(id, name, age, gender, salary);
				emps.add(emp);
			}
			System.out.println("������ϣ�");
			//�������emps����
			for(Emp e : emps){
				System.out.println(e);
			}
			
			/*
			 * �κ�ϰ��4	���xml�ĵ�
			 */
			XMLWriter writer = new XMLWriter();
			FileOutputStream fos = new FileOutputStream(new File("myemp_server.xml"));
			writer.setOutputStream(fos);//���ô�ʱ�������
			writer.write(doc);//��doc����д��
			writer.close();//�ر�д����
			
			server.close();//�رշ���˵��׽���
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}










