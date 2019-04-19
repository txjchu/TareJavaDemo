package com.tare.Emp.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AOP���������operate ���� 		logger ��¼��
 * 		���ڼ�¼��־������������ʾspring AOP�ĸ���֪ͨ���͡�
 * @author Administrator
 *
 */
public class OperateLogger {
	/*
	 * ǰ��֪ͨ������֪ͨ������֪ͨ��ʹ�÷���
	 */
	public void log1(){//ǰ��֪ͨ
		//��¼��־
		System.out.println("-->log1:��¼�û�������Ϣ");
	}
	/*
	 * ����֪ͨ
	 */
	public Object log2(ProceedingJoinPoint p) throws Throwable{//����֪ͨ
		//��ȡĿ���������
		String className = p.getTarget().getClass().getName();//p���Ի�ȡ����ǰ��֪ͨ��Ŀ�����
		//��ȡ��֪ͨ�ĵ��õķ�����
		String method = p.getSignature().getName();
		//��ǰϵͳʱ��
		String date = new SimpleDateFormat("yyyy-MM-dd E hh:mm:ss").format(new Date());
		//ƴ����־��Ϣ
		String msg = "-->log2:�û���"+ date +",ִ����"+ className +"."+ method +"()";
		//���
		System.out.println(msg +"	[��Ϊ����֪ͨ��ǰ�ò���]");
		
		//ִ��Ŀ������ķ���
		Object obj = p.proceed();
		
		//ģ�⣺�ڵ���Ŀ�����ҵ�񷽷�������һЩ����
		System.out.println("-->log2:������Ŀ�����ҵ�񷽷���....		[��Ϊ����֪ͨ�ĺ��ò���]");
		
		return obj;
	}
	//����֪ͨ
	public void log3(){
		System.out.println("-->log3:�˴�Ϊ����ִ֪ͨ�еĹ���....");
	}
	//�쳣֪ͨ
	public void log4(Exception e){
		StackTraceElement[] stackTrace = e.getStackTrace();
		System.out.println("-->log4:�쳣��ϢΪ��"+ stackTrace +",�����쳣���쳣ִ֪ͨ�еĲ���...");
	}
	//����֪ͨ
	public void log5(){
		System.out.println("-->log4:�˴�Ϊ����ִ֪ͨ�еķ���....");
	}
}
