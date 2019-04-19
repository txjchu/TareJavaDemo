package org.tarena.note.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * ��װ��׮��Ϣ���������������ʹ��
 * @author Administrator
 *
 */
@Component//ɨ�赽Spring����
@Aspect	//ָ��Ϊ����
public class DebugLoggerBean {
	@Before("within(org.tarena.note.controller..*)")
	public void debugController(){
		System.out.println("-->DebugLoggerBean:����Controll��������...");
	}
	
	@Before("within(org.tarena.note.service.*)")
	public void debugService(){
		System.out.println("-->DebugLoggerBean:����Service��������");
	}
}
