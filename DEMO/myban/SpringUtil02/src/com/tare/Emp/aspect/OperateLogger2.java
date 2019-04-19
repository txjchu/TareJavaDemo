package com.tare.Emp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * �������2��
 * ��ϰʹ��ע�ⷽʽ����AOP
 * @author Administrator
 *
 */
@Component		//ע�����������Ϊһ��bean
@Aspect			//����Ϊһ���������
public class OperateLogger2 {
	
	@Before("within(com.tare.Emp.controller..*)")		//ǰ��֪ͨ
	public void log1(){
		System.out.println("-->log1:��¼�û�����...[ǰ��֪ͨ]");
	}
	@AfterReturning("within(com.tare.Emp.controller..*)")//����֪ͨ
	public void log2(){
		System.out.println("-->log2:����֪ͨ�Ĳ���...[����֪ͨ]");
	}
	@After("within(com.tare.Emp.controller..*)")		 //����֪ͨ
	public void log3(){	
		System.out.println("-->log3:����֪ͨ�Ĳ���...[����֪ͨ]");
	}
	@Around("within(com.tare.Emp.controller..*)")		 //����֪ͨ
	public Object log4(ProceedingJoinPoint p) throws Throwable{
		System.out.println("-->log4:����֪ͨǰ�ò��ֵĲ���....[����֪ͨǰ�ò���]");
		Object obj = p.proceed();//ִ�б�֪ͨ�ķ���
		System.out.println("-->4:����֪ͨ�ĺ��ò��ֵĲ���...[����֪ͨ���ò���]");
		return obj;
	}
	@AfterThrowing(pointcut="within(com.tare.Emp.controller..*)", throwing="e")
	public void log5(Exception e){
		System.out.println("-->log5:�쳣֪ͨ�Ĳ�������ȡ�����쳣����Ϊ"+ e.getClass().getName() +"...[�쳣֪ͨ]");
	}
}









