package day07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��DOM����XML�ĵ�
 * @author Administrator
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		try {
			/*
			 * ����XML��������:
			 * 1:�������ڶ�ȡXML�ĵ���SAXReader
			 * 2:ָ��SAXReaderȥ��ȡXML�ĵ�����ȡ
			 *   �Ĺ��̾��ǽ����Ĺ��̣�����Ὣ����
			 *   �ĵ�ȫ����������һ��Document����
			 *   ����ʽ���ء�
			 *   DOM��ʱ����Դ��������������Ὣ
			 *   �ĵ�������Document���󱣴����ڴ�
			 *   �С�
			 * 3:ͨ��Document��ȡ��Ԫ��(����ǩ)
			 * 4:�����ĵ��Ľṹ��������Ԫ���µ�ÿһ��
			 *   ��Ԫ�أ��ﵽ��ȡXML�ĵ����ݵ�����
			 *   
			 */
			//1
			SAXReader reader = new SAXReader();
			
			//2
			Document doc = reader.read(
				new File("emplist.xml")
			);
			
			/*
			 * 3 Document�ṩ�ķ���:
			 * Element getRootElement()
			 * ������ȡ��XML�ĵ��ĸ�Ԫ�أ��ڵ�ǰ
			 * �����о���ָ<list>��ǩ��
			 * 
			 * Element��:
			 * �����ÿһ��ʵ�������Ա�ʾXML�ĵ�
			 * �е�һ��Ԫ��(һ�Ա�ǩ)
			 * ͨ��Element���Ի�ȡ��Ԫ�ص����ԣ�
			 * ��Ԫ�ص����ݡ�
			 */
			Element root 
				= doc.getRootElement();
			
			//�����Ԫ������
//			System.out.println(
//				"��Ԫ��:"+root.getName());
			
			/*
			 * 
			 * Element��ȡһ��Ԫ���е���Ԫ��
			 * ����ط���:
			 * List elements()
			 * ��ȡ��ǰԪ���µ�������Ԫ�أ�����ÿһ��
			 * ��Ԫ��(Elementʵ��)����һ��List����
			 * �󷵻ء�
			 * 
			 * List elements(String name)
			 * ��ȡ��ǰԪ��������ͬ����Ԫ�أ�����һ��
			 * List���ء�
			 * 
			 * Element element(String name)
			 * ��ȡ��ǰ��ǩ��ָ�����ֵ��ӱ�ǩ��Ҫ����
			 * �����Ļ�ȡ��һ��
			 * 
			 */
			//��ȡ����ǩ�µ������ӱ�ǩ
			List<Element> elements
						= root.elements();
			/*
			 * ��list��ǩ�µ������ӱ�ǩempת��
			 * Ϊ���ɸ�Empʵ����Ȼ�����һ������
			 * �б���
			 */
			List<Emp> emps 
				= new ArrayList<Emp>();
			//����ÿһ��<emp>��ǩ
			for(Element empEle:elements){
				//��ȡ����
				Element nameEle
					= empEle.element("name");
				/*
				 * Element�ṩ�˻�ȡ��ʼ�����
				 * ��ǩ�м��ı��ķ���:
				 * String getText()
				 * String getTextTrim()ȥ�հ�
				 */
				String name = nameEle.getText();
//				System.out.println("name:"+name);
				
				//��������
				int age = Integer.parseInt(
					/*
					 * ��ȡ��ǰ��ǩ�¸������ֵ��ӱ�ǩ
					 * �м���ı���
					 * �������:
					 * ��ȡemp��ǩ�µ��ӱ�ǩage�м��
					 * �ı���
					 * ��ͬ�������ȡname��ǩ�м��ı���
					 * ������롣	
					 */
					empEle.elementTextTrim("age")
				);
				String gender
					= empEle.elementText("gender");
				
				int salary
					= Integer.parseInt(
						empEle.elementTextTrim("salary")	
					);
				/*
				 * Element�ṩ�˻�ȡ���Եķ���:
				 * Attribute attribute(String str)
				 * ��ȡָ�����ֵ����ԡ�
				 * 
				 * Attribute��:
				 * ��ʵ����������һ����ǩ�е�һ�����ԡ�
				 * ���Էֱ��ȡ���Ե������Լ���Ӧ��ֵ��
				 */
				Attribute attr
					= empEle.attribute("id");
				int id = Integer.parseInt(
					attr.getValue()
				);
				
				Emp emp = new Emp(id, name, age, gender, salary);
				emps.add(emp);
			}
			
			//��׮
			for(Emp emp : emps){
				System.out.println(emp);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




