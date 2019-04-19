package org.tare.ioc;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * ��ϰʹ��ע�ⷽʽIOC
 * @author Administrator
 *
 */
@Component("example")
@Scope("singleton")
public class ExampleBean implements Serializable{//ʵ�����л��ӿ�
	public ExampleBean(){
		System.out.println("ʵ����ExampleBean: "+ this);		
	}
	@PostConstruct
	public void init(){
		System.out.println("��ʼ��ExampleBean "+ this);
	}
	@PreDestroy
	
	public void destroy(){
		System.out.println("����ExampleBean "+ this);
	}
	public void execute(){
		System.out.println("ִ��ExampleBeanִ�з���...." );
	}
}
