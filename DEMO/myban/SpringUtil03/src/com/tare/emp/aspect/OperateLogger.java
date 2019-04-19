package com.tare.emp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AOP方面组件
 * @author Administrator
 *
 */
@Component					//注解为一个bean
@Aspect						//注解为一个方面组件
public class OperateLogger {

	@Before("within(com.tare.emp.controller..*)")
	public void log1(){							// 前置通知
		System.out.println("-->log1:记录用户操作的方面组件的操作....[前置通知]");
	}
	@Around("within(com.tare.emp.controller..*)")				// 切入了所有controller组件中
	public Object log2(ProceedingJoinPoint p) throws Throwable{	// 环绕通知		必须有参数
		System.out.println("-->log2:记录用户操作的方面组件的操作...[环绕通知前置部分]");
		Object obj = p.proceed();//执行目标组件中的业务方法。
		System.out.println("-->log2:记录用户操作的方面组件的操作...[环绕通知后置部分]");
		return obj;
	}
}
