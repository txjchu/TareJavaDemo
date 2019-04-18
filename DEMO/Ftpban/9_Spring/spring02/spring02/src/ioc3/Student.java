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
		System.out.println("Student's init����...");
	}
	
	public void service(){
		System.out.println("Student's service����...");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Student's destroy����...");
	}
	
	public Student() {
		System.out.println("Student's ������...");
	}

}
