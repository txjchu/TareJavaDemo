package org.tarena.note.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//��װ��׮��Ϣ,�������������ʹ��
@Component//ɨ�赽Spring����
@Aspect//ָ��Ϊ����
public class DebugLoggerBean {
	//��ǰ��֪ͨ���뵽����Controller����ǰ����
	@Before("within(org.tarena.note.controller..*)")
	public void debugController(){
		System.out.println("����Controller��������");
	}
	
	@Before("within(org.tarena.note.service.*)")
	public void debugService(){
		System.out.println("����Service��������");
	}
	
}



