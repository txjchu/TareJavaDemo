package ioc3;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("programmer")	//--Ĭ�ϵ������������Զ��ҵ�
public class Programmer implements Serializable {
	private Computer computer;
	
	@Autowired	//--д�ڹ�����ǰ�棬��ʾ�������ù��췽ʽע��
	public Programmer(@Qualifier("cp")Computer computer) {
		this.computer = computer;
	}

	@Override
	public String toString() {		
		return "computer:"+computer;
	}
	
}
