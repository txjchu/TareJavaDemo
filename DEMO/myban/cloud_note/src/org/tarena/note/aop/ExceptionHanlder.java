package org.tarena.note.aop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ���쳣��¼�ļ���������ʹ��
 * @author Administrator
 *
 */
@Component
@Aspect
public class ExceptionHanlder {
	//�쳣���������hanlder()�������쳣��Ϣ����ex��
	@AfterThrowing(throwing="ex",pointcut="within(org.tarena.note.controller..*)")
	public void hanlder(Exception ex){//--ex�������ã�����Ŀ������׳����쳣����(����д�ĸ������ĳһ�������쳣)
		//���쳣��Ϣд���ļ�
//		System.out.println("�����쳣��"+ex);
		try {
			FileWriter fw = new FileWriter("note_error.log",true);//note_error.log�����·��Ĭ������tomcat/ben��
			PrintWriter pw = new PrintWriter(fw);//PrintWriter�������ḻ
			ex.printStackTrace(pw);//��������ͨ��FileWriter���TomCatջ��Ϣ
			//������չ������ջ��Ϣ�����õ���Ϣ�����Կ�������ĸ�ʽ�����Ķ�������ÿ�����һ����־�����԰����쳣�ļ���С����
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("��¼�쳣��־ʧ��");
		}//--�����½�һ���쳣��־�ļ�,true��ʵ�ּ�¼�ۼ�
		
	}
}
