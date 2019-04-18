package ioc3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stu")
@Scope("prototype")
public class Student {

	public Student() {
		System.out.println("Student's ¹¹ÔìÆ÷...");
	}

}
