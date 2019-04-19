package day07.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * ʹ��DOM����һ��XML�ĵ�
 * @author Administrator
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		try {
			List<Emp> emps = new ArrayList<Emp>();
			emps.add(new Emp(1, "����", 25, "��", 5000));
			emps.add(new Emp(2, "����", 26, "Ů", 6000));
			emps.add(new Emp(3, "����", 27, "Ů", 7000));
			emps.add(new Emp(4, "����", 28, "��", 8000));
			emps.add(new Emp(5, "Ǯ��", 29, "Ů", 9000));
			/*
			 * ���裺
			 * 1.����һ���հ�Document���󣬱�ʾһ���հ��ĵ���
			 * 2.���ĵ�����Ӹ�Ԫ�ض���
			 * 3.�����ĵ�Ҫ���ɵĽṹ�������Ԫ����׷����Ԫ���Դﵽ�ýṹ��
			 * 4.����XMLWriter
			 * 5.��Docment����ͨ��XMLWriterд����XML�ĵ���
			 */
			//1.�����հ�Document����
			Document doc = DocumentHelper.createDocument();
			//2.���ĵ�����Ӹ�Ԫ�ض���
			//3.�����ĵ�Ҫ���ɵĽṹ�������Ԫ����׷����Ԫ���Դﵽ�ýṹ��
			/*
			 * Document�ṩ�˴�������ǩ�ķ�����
			 * Element addElement(String name)
			 * ��Ӹ������ֵĸ�Ԫ�أ�����XML�ĵ���ֻ����һ����Ԫ�أ����Ը÷������ܵ��õڶ��Ρ�������׳��쳣������ֵ�ͱ�ʾ�ո���ӵĸ�Ԫ�ء�
			 * 
			 */
			Element root = doc.addElement("list");
			/*
			 * �������е�ÿһ��Emp����ת��Ϊһ��<emp>��ǩ�������浽����ǩ<list>�С�
			 */
			for(Emp emp : emps){
				/*
				 * ���Ԫ��������ӱ�ǩemp
				 * Element�ṩ������ӱ�ǩ�ķ�����
				 * Element addElement(String name)
				 */
				Element empEle = root.addElement("emp");
				/*
				 * Element addAttribute(String name, String value)
				 * ��ǰ��ǩ����Ӹ����������Ӧֵ�����ԡ�
				 */
				empEle = empEle.addAttribute("id", emp.getId() +"");//��Ϊ�÷�������Ϊ2��String����˵ڶ���������Ҫת��ΪString 
				/*
				 * ���name�ӱ�ǩ 
				 */
				Element nameEle = empEle.addElement("name");
				/*
				 * Element �ṩ���ǩ������ı��ķ�����
				 * Element addText(String text)
				 * ��ǰ��ǩ�м���Ӹ������ı���Ϣ������ֵ���ǵ�ǰ��ǩ����������׷�Ӳ�������StringBuffered����ط������ơ�
				 */
				nameEle.addText(emp.getName());//��name��ǩ�м���name��ֵ��
				//���age��ǩ
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge() +"");//��Ϊage��int�ͣ���˼��Ͽ��ַ���ת��ΪString��
				
				//���gender
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				
				//���salary
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary() +"");
				
			}
			//4.����XMLWriter��������д��XML�ĵ�
//			XMLWriter writer = new XMLWriter();
			XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());//Ư����ʽ
			FileOutputStream fos = new FileOutputStream("myemp.xml");
			writer.setOutputStream(fos);
			//��Documentд����xml�ĵ�
			writer.write(doc);
			writer.close();
			System.out.println("����xml�ĵ���ϣ�");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
















