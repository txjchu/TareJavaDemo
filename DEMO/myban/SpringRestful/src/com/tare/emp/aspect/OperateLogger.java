package com.tare.emp.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP���������
 * ���ڼ�¼�û�������־
 * @author Administrator
 *
 */
@Component
@Aspect
public class OperateLogger {
		
	@Around("within(com.tare.emp.controller..*)")
	public Object log1(ProceedingJoinPoint p) throws Throwable{
		String className = p.getTarget().getClass().getName();	//��ȡ�û���������
		String method = p.getSignature().getName();				//��ȡ�û������ķ���
		String date = new SimpleDateFormat("yyyy-MM-dd E hh:mm:ss").format(new Date());
		String msg = "-->log1:"+ date +" ��ʼ��¼�û�����"+ className +"."+ method +"()";
		System.out.println(msg +"...[����֪ͨǰ�ò���]");
		Object obj = p.proceed();
		System.out.println("-->log1:�û��������...[����֪ͨ���ò���]");
		System.out.println(obj);
		return obj;
	}
}
