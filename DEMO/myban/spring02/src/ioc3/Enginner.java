package ioc3;
/**
 * ��Setter����ע��
 */
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("enginner")
public class Enginner implements Serializable {
//	@Autowired			//--д������(��Ա������)ǰ�棬ִֻ��һ��this.computer = computer;
//	@Qualifier("")     engineer��ȷƴд
	private Computer computer;
	
	public Computer getComputer() {
		return computer;
	}

	@Autowired	//--����д��get����ǰ��,Ҳ����д��set����ǰ��
	public void setComputer(@Qualifier("cp")Computer computer) {
		this.computer = computer;
		System.out.println("computerע��ɹ�");
	}

	@Override
	public String toString() {
		return "computer:"+computer;
	}

	
	
}
