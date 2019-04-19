package org.tare.ioc;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 练习使用注解方式IOC
 * @author Administrator
 *
 */
@Component("example")
@Scope("singleton")
public class ExampleBean implements Serializable{//实现序列化接口
	public ExampleBean(){
		System.out.println("实例化ExampleBean: "+ this);		
	}
	@PostConstruct
	public void init(){
		System.out.println("初始化ExampleBean "+ this);
	}
	@PreDestroy
	
	public void destroy(){
		System.out.println("销毁ExampleBean "+ this);
	}
	public void execute(){
		System.out.println("执行ExampleBean执行方法...." );
	}
}
