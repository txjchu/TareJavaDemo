package day07.case07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import day07.copy.Emp;

/**
 * ����3	д��XML�ĵ�
 * @author Administrator
 *
 */
public class TestWriteXML {
	public static void main(String[] args) {
		try {
			List<Emp> emps = new ArrayList<Emp>();
			emps.add(new Emp(1, "����", 25, "��", 3000));
			emps.add(new Emp(2, "����", 26, "Ů", 2500));
			emps.add(new Emp(3, "����", 27, "��", 3500));
			emps.add(new Emp(4, "����", 26, "Ů", 4000));
			//�����հ�DOM�ĵ�����
			Document doc = DocumentHelper.createDocument();
			//��Ӹ�Ԫ��
			Element root = doc.addElement("list");
			/*
			 * ����emps���ϣ��ڱ��������н������е�emp����תΪxml
			 */
			for(Emp emp : emps){
				//���2����ǩemp��������������id
				Element empEle = root.addElement("emp");
				empEle = empEle.addAttribute("id", emp.getId() +"");
				//�������
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				//�������
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge() +"");
				//����Ա�
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				//���н��
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary() +"");
			}
			//д��XML
			XMLWriter writer = new XMLWriter();
			FileOutputStream fos = new FileOutputStream("myxmlcopy.xml");
			writer.setOutputStream(fos);
			writer.write(doc);
			writer.close();
			System.out.println("д��XML��ϣ�");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}















