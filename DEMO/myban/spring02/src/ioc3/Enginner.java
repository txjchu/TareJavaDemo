package ioc3;
/**
 * 用Setter方法注入
 */
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("enginner")
public class Enginner implements Serializable {
//	@Autowired			//--写在属性(成员变量？)前面，只执行一句this.computer = computer;
//	@Qualifier("")     engineer正确拼写
	private Computer computer;
	
	public Computer getComputer() {
		return computer;
	}

	@Autowired	//--可以写在get方法前面,也可以写在set方法前面
	public void setComputer(@Qualifier("cp")Computer computer) {
		this.computer = computer;
		System.out.println("computer注入成功");
	}

	@Override
	public String toString() {
		return "computer:"+computer;
	}

	
	
}
