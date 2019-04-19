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
 * 方面组件2：
 * 练习使用注解方式配置AOP
 * @author Administrator
 *
 */
@Component		//注解组件，声明为一个bean
@Aspect			//声明为一个方面组件
public class OperateLogger2 {
	
	@Before("within(com.tare.Emp.controller..*)")		//前置通知
	public void log1(){
		System.out.println("-->log1:记录用户操作...[前置通知]");
	}
	@AfterReturning("within(com.tare.Emp.controller..*)")//后置通知
	public void log2(){
		System.out.println("-->log2:后置通知的操作...[后置通知]");
	}
	@After("within(com.tare.Emp.controller..*)")		 //最终通知
	public void log3(){	
		System.out.println("-->log3:最终通知的操作...[最终通知]");
	}
	@Around("within(com.tare.Emp.controller..*)")		 //环绕通知
	public Object log4(ProceedingJoinPoint p) throws Throwable{
		System.out.println("-->log4:环绕通知前置部分的操作....[环绕通知前置部分]");
		Object obj = p.proceed();//执行被通知的方法
		System.out.println("-->4:环绕通知的后置部分的操作...[环绕通知后置部分]");
		return obj;
	}
	@AfterThrowing(pointcut="within(com.tare.Emp.controller..*)", throwing="e")
	public void log5(Exception e){
		System.out.println("-->log5:异常通知的操作，获取到的异常类型为"+ e.getClass().getName() +"...[异常通知]");
	}
}









