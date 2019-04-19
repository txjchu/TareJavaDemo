package day07;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��XPath����XML�ĵ�����
 * @author Administrator
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("myemp.xml"));
			
			/*
			 * List selectNodes(String xpath)
			 * ����xpath ����xml �ĵ�����
			 */
			
			String xpath = "/list/emp/name";
			String xpath1 = "/list/emp/salary";
			String xpath2 = "/list/emp[salary>6000]/name";	//���ʸ���6000��Ա��������
			String xpath3 = "/list/emp[gender='Ů']/name";	//�Ա���Ů������
			String xpath4 = "/list/emp[gender='��' and salary>5000]/name";//���ʸ���5000������Ա��������
			String xpath5 = "/list/emp[@id='3']/salary";		//id��3��Ա���Ĺ���
			
			List list = doc.selectNodes(xpath);
			List list1 = doc.selectNodes(xpath1);
			List list2 = doc.selectNodes(xpath2);
			List list3 = doc.selectNodes(xpath3);
			List list4 = doc.selectNodes(xpath4);
			List list5 = doc.selectNodes(xpath5);
			
			for(Object obj : list){
				Element ele = (Element)obj;
				System.out.println("name:"+ele.getText());
			}
			for(Object obj : list1){
				Element ele1 = (Element)obj;
				System.out.println("salary:"+ele1.getText());
			}
			for(Object obj : list2){
				Element ele2 = (Element)obj;
				System.out.println("���ʴ���6000��Ա����������"+ele2.getText());
			}
			for(Object obj : list3){
				Element ele3 = (Element)obj;
				System.out.println("�Ա���Ů��Ա����������"+ele3.getText());
			}
			for(Object obj : list4){
				Element ele4 = (Element)obj;
				System.out.println("IDΪ3��Ա���Ĺ��ʣ�"+ele4.getText());
			}
			for(Object obj : list5){
				Element ele5 = (Element)obj;
				System.out.println("���ʴ���6000��Ա���Ĺ��ʣ�"+ele5.getText());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
