package day07;

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
			emps.add(new Emp(1,"����",25,"��",5000));
			emps.add(new Emp(2,"����",26,"Ů",6000));
			emps.add(new Emp(3,"����",27,"��",7000));
			emps.add(new Emp(4,"����",28,"Ů",8000));
			emps.add(new Emp(5,"Ǯ��",29,"��",9000));
			
			
			/*
			 * ���裺
			 * 1.����һ��Document���󣬱�ʾһ���հ��ĵ�;
			 * 2.���ĵ�����Ӹ�Ԫ��;
			 * 3.�����ĵ�Ҫ���ɵĽṹ�������Ԫ����׷����Ԫ���Դﵽ�ýṹ;
			 * 4.����XMLWriter;
			 * 5.��Document����ͨ��XMLWriterд������XML�ĵ���
			 */
			//1
			Document doc 
				= DocumentHelper.createDocument();		//----����new ��ֱ�ӵ���DocumentHelper��һ������.createDocument() 
			
			//2
			/*
			 * Document�ṩ����Ӹ���ǩ�ķ���
			 * Element addElement(String name)
			 * ��Ӹ������ֵĸ�Ԫ�أ�����XML�ĵ���ֻ����һ����Ԫ�أ�
			 * ���Ը÷������ܵ����������ϣ�������׳��쳣��
			 * ����ֵ��ʾ�ո���ӵĸ�Ԫ�ء�
			 * 
			 */
			Element root = doc.addElement("list");
			
			/*
			 * �������е�ÿһ��Emp����ת��Ϊһ��<emp>��ǩ�������浽����ǩ<list>�С�
			 */
			for(Emp emp : emps){
				//�����ǩ������ӱ�ǩemp
				/*
				 * Element�ṩ������ӱ�ǩ�ķ�����
				 * Element addElement(String name)
				 */
				Element empEle = root.addElement("emp");
				
				//���name �ӱ�ǩ
				Element nameEle = empEle.addElement("name");
				/*
				 * Element�ṩ�ķ�����
				 * Element addText(String str)
				 * ��ǰ��ǩ�м���Ӹ������ı���Ϣ������ֵ���ǵ�ǰ��ǩ��
				 * ��������׷�Ӳ�������StringBuilder ����ط������ơ�
				 */
				nameEle.addText(emp.getName());
				
				//���age
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");		//----��������ת�ַ���������ֱ�Ӽ�һ�����ַ�����
														//----��������ת��Ϊ�ַ�����	
				//���gender
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				//���salary
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary()+"");
				
				/*
				 * Element addAttribute(String name,String value)
				 * ��ǰ��ǩ����Ӹ������������Ӧֵ������
				 */
				empEle.addAttribute("id", emp.getId()+"");
				
			}
			
			XMLWriter writer = new XMLWriter(
					OutputFormat.createPrettyPrint()	//----����һ���Ű����ļ�
			);		//----�߼���
			
			FileOutputStream fos = new FileOutputStream("myemp.xml");	//----����chage
			writer.setOutputStream(fos);
			//��Document д����xml �ĵ�
			writer.write(doc);
			
			writer.close();		//Ӧ��д��falin  ���棬����ҲҪ��try
			System.out.println("����xml�ĵ���ϣ�");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
