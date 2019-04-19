package day07.case07;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import day07.copy.Emp;

/**
 * ����2	��ȡXML�ĵ�������Emp��Ϣ
 * @author Administrator
 *
 */
public class TestDom {
	
	//����2
	@Test
	public void testReadXML(){
		
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			Element root = doc.getRootElement();//��ȡdoc�ĸ�Ԫ��
			List<Element> eles = root.elements();//���ظ�Ŀ¼�������ӱ�ǩ
			List<Emp> emps = new ArrayList<Emp>();//���ڴ��汻ת��ΪEmp���͵ı�ǩ
			for(Element ele : eles){
				//��ȡ����
				Element nameEle = ele.element("name");
				String name = nameEle.getText();
				//��ȡ����
				Element ageEle = ele.element("age");
				int age = Integer.parseInt(ageEle.getText());
				//��ȡн��
				Element salaryEle = ele.element("salary");
				int salary = Integer.parseInt(salaryEle.getText());
				//��ȡ�Ա�
				Element genderEle = ele.element("gender");
				String gender = genderEle.getText();
				//��ȡid
				int id = Integer.parseInt(ele.attribute("id").getValue());
				//�����Emp����
				Emp emp = new Emp(id , name, age, gender, salary);
				emps.add(emp);//��ӵ�emps������
			}
			//����emps����
			for(Emp emp : emps){
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//����4
	@Test
	public void testPath(){
		try {
			//����·����Ҫ���ȡid=2��empԪ��
			String path = "/list/emp[@id = '2']";
			//����doc����
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			//��ȡָ��·����Ԫ��
			List<Element> list = doc.selectNodes(path);
			//����list������ת��Ϊemp���󣬲����
			for(Element ele : list){//�����listָ������
				String name = ele.element("name").getTextTrim();
				int age = Integer.parseInt(ele.element("age").getTextTrim());
				int salary = Integer.parseInt(ele.element("salary").getTextTrim());
				int id = Integer.parseInt(ele.attribute("id").getValue());
				//��ȡid����
//				Attribute attr = ele.attribute("id");
				String gender = ele.element("gender").getTextTrim();
				Emp emp = new Emp(id, name, age, gender, salary);
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}














