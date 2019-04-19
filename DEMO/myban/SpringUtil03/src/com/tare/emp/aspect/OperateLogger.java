package com.tare.emp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP�������
 * @author Administrator
 *
 */
@Component					//ע��Ϊһ��bean
@Aspect						//ע��Ϊһ���������
public class OperateLogger {

	@Before("within(com.tare.emp.controller..*)")
	public void log1(){							// ǰ��֪ͨ
		System.out.println("-->log1:��¼�û������ķ�������Ĳ���....[ǰ��֪ͨ]");
	}
	@Around("within(com.tare.emp.controller..*)")				// ����������controller�����
	public Object log2(ProceedingJoinPoint p) throws Throwable{	// ����֪ͨ		�����в���
		System.out.println("-->log2:��¼�û������ķ�������Ĳ���...[����֪ͨǰ�ò���]");
		Object obj = p.proceed();//ִ��Ŀ������е�ҵ�񷽷���
		System.out.println("-->log2:��¼�û������ķ�������Ĳ���...[����֪ͨ���ò���]");
		return obj;
	}
}
