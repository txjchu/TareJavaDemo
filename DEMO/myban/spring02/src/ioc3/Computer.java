package ioc3;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("cp")	//----����������Ĭ����component��������Ĭ�ϵ���singleton
public class Computer implements Serializable {

	public Computer() {
		System.out.println("Computer's ��������������....");
	}
	
}
