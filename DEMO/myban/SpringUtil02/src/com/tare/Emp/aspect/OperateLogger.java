package com.tare.Emp.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AOP方面组件，operate 运行 		logger 记录器
 * 		用于记录日志方面的组件，演示spring AOP的各种通知类型。
 * @author Administrator
 *
 */
public class OperateLogger {
	/*
	 * 前置通知，后置通知，最终通知的使用方法
	 */
	public void log1(){//前置通知
		//记录日志
		System.out.println("-->log1:记录用户操作信息");
	}
	/*
	 * 环绕通知
	 */
	public Object log2(ProceedingJoinPoint p) throws Throwable{//环绕通知
		//获取目标组件类名
		String className = p.getTarget().getClass().getName();//p可以获取到当前被通知的目标组件
		//获取被通知的调用的方法名
		String method = p.getSignature().getName();
		//当前系统时间
		String date = new SimpleDateFormat("yyyy-MM-dd E hh:mm:ss").format(new Date());
		//拼接日志信息
		String msg = "-->log2:用户在"+ date +",执行了"+ className +"."+ method +"()";
		//输出
		System.out.println(msg +"	[此为环绕通知的前置部分]");
		
		//执行目标组件的方法
		Object obj = p.proceed();
		
		//模拟：在调用目标组件业务方法后，做的一些处理。
		System.out.println("-->log2:调用完目标组件业务方法后....		[此为环绕通知的后置部分]");
		
		return obj;
	}
	//后置通知
	public void log3(){
		System.out.println("-->log3:此处为后置通知执行的过程....");
	}
	//异常通知
	public void log4(Exception e){
		StackTraceElement[] stackTrace = e.getStackTrace();
		System.out.println("-->log4:异常信息为："+ stackTrace +",发生异常后异常通知执行的操作...");
	}
	//最终通知
	public void log5(){
		System.out.println("-->log4:此处为最终通知执行的方法....");
	}
}
