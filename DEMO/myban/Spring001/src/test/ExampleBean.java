package test;
/**
 * ��ʾbean����������
 * @author Administrator
 *
 */
public class ExampleBean {
	//������
	public ExampleBean(){
		System.out.println("ʵ����ExampleBean:"+ this);
	}
	//��ʼ��
	public void init(){
		System.out.println("��ʼ��Bean��"+ this);
	}
	//ִ��ĳ����
	public void execute(){
		System.out.println("ִ��Bean�еķ���");
	}
	//����
	public void destroy(){
		System.out.println("����Bean��"+ this);
	}
}
