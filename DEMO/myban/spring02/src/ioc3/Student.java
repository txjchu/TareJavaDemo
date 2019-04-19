package ioc3;
/**
 * ��ʾ�����ɨ��
 */
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("stu")	//���Ը�bean��idʹ�ñ���������Component����ӣ���xxx������----- ��� --��ʵ����һ��bean----
@Scope("singleton")	//���Ը�bean��������������scope(��Χ)����Ϊԭ��(����)����д�Ļ�Ĭ��Ϊ������singleton��----
public class Student implements Serializable {
	public Student(){
		System.out.println("Student�Ĺ�������������");
	}
	@PostConstruct
	public void init(){
		System.out.println("Student's init(��ʼ��)����");
		
	}
	public void service(){
		System.out.println("Student's service����");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("Student's destroy�ķ���");
	}
	
}
