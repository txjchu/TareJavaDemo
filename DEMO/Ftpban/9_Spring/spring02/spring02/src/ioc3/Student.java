package ioc3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stu")
@Scope("singleton")  
public class Student {
	@PostConstruct
	public void init(){
		System.out.println("Student's init方法...");
	}
	
	public void service(){
		System.out.println("Student's service方法...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Student's destroy方法...");
	}
	
	public Student() {
		System.out.println("Student's 构造器...");
	}

}
