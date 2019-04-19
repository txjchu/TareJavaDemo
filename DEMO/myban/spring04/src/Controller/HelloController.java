package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ʹ��ע���ʶ���õ�MVCӦ��
 * @author Administrator
 * ������ʽ����
 */
//ʹ��ע���ʶע�룬����Ҫ��ʵ��Controller�ӿ�
@Controller
@RequestMapping("/hellodemo")
public class HelloController {
	//�����������Զ��壬����ֵ�������ַ���(��ͼ��)String������ModelAndView��
	@RequestMapping("/hello.do")	//----�ñ�ע��ʾ���������Ӧ�����ĸ�����----�൱��HandlerMapping
	public String hello1(){		 
		System.out.println("hello1��������ִ�У�����ܿ����þ仰����ʾ�������ִ����");
		return "hello";
	}
	/**
	 * ʹ��ע���ʶ���õ�MVCģʽ�У���Controller�����棬������Ӷ����������
	 * ������صĲ�������ͼ���Ļ������������ݵ�ʱ���÷���ΪModelAndView�ķ�����
	 * @return
	 */
	@RequestMapping("/hello2.do")
	public ModelAndView hello2(){
		System.out.println("hello2������ִ��...");
		return new ModelAndView("hello");
	}
}
