package org.tarena.note.aop;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//���쳣��¼�ļ�,������ʹ��
@Component
@Aspect
public class ExceptionHanlder {

	//ex�������ã�����Ŀ������׳����쳣����
	@AfterThrowing(throwing="ex",
	pointcut="within(org.tarena.note.controller..*)")
	public void hanlder(Exception ex){
		//���쳣��Ϣд���ļ�
		//System.out.println("�����쳣��"+ex);
		try{
			FileWriter fw = 
				new FileWriter("note_error.log",true);
			PrintWriter pw = new PrintWriter(fw);
			ex.printStackTrace(pw);
			pw.flush();
			pw.close();
			fw.close();
		}catch(Exception e){
			System.out.println("��¼�쳣��־ʧ��");
		}
	}
	
}
