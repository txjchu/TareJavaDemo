package org.tarena.note.aop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 将异常记录文件，当切面使用
 * @author Administrator
 *
 */
@Component
@Aspect
public class ExceptionHanlder {
	//异常发生后调用hanlder()方法，异常信息传入ex。
	@AfterThrowing(throwing="ex",pointcut="within(org.tarena.note.controller..*)")
	public void hanlder(Exception ex){//--ex参数作用：接收目标组件抛出的异常对象(可以写的更具体的某一种类型异常)
		//将异常信息写入文件
//		System.out.println("发生异常了"+ex);
		try {
			FileWriter fw = new FileWriter("note_error.log",true);//note_error.log此相对路径默认是在tomcat/ben里
			PrintWriter pw = new PrintWriter(fw);//PrintWriter方法更丰富
			ex.printStackTrace(pw);//借助流，通过FileWriter输出TomCat栈信息
			//可以扩展，过滤栈信息中有用的信息，可以控制输出的格式便于阅读，可以每天产生一份日志，可以按照异常文件大小处理
			pw.flush();
			pw.close();
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("记录异常日志失败");
		}//--产生新建一个异常日志文件,true是实现记录累加
		
	}
}
