package com.tare.emp.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP方面组件：
 * 用于记录用户操作日志
 * @author Administrator
 *
 */
@Component
@Aspect
public class OperateLogger {
		
	@Around("within(com.tare.emp.controller..*)")
	public Object log1(ProceedingJoinPoint p) throws Throwable{
		String className = p.getTarget().getClass().getName();	//获取用户操作的类
		String method = p.getSignature().getName();				//获取用户操作的方法
		String date = new SimpleDateFormat("yyyy-MM-dd E hh:mm:ss").format(new Date());
		String msg = "-->log1:"+ date +" 开始记录用户操作"+ className +"."+ method +"()";
		System.out.println(msg +"...[环绕通知前置部分]");
		Object obj = p.proceed();
		System.out.println("-->log1:用户操作完成...[环绕通知后置部分]");
		System.out.println(obj);
		return obj;
	}
}
