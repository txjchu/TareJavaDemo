package ioc3;
/**
 * 演示：组件扫描
 */
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("stu")	//可以给bean的id使用别名。即在Component后面加（“xxx”）。----- 组件 --其实就是一个bean----
@Scope("singleton")	//可以给bean设置作用域，设置scope(范围)属性为原型(多例)，不写的话默认为单例“singleton”----
public class Student implements Serializable {
	public Student(){
		System.out.println("Student的构造器被调用了");
	}
	@PostConstruct
	public void init(){
		System.out.println("Student's init(初始化)方法");
		
	}
	public void service(){
		System.out.println("Student's service方法");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("Student's destroy的方法");
	}
	
}
