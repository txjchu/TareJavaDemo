package web;
//创建好这个类，继承于HttpServlet，复写父类
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	//自动生成的----右键--Source--@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//1.设置输出内容的类型
		res.setContentType("text/html");
		//2.获取Writer
		PrintWriter w = res.getWriter();
		//3.输入内容(HTML片段)
		w.println("<h1>Hello,Servlet.</h1>");
		//4.关闭Writer
		w.close();
		//5.配置
	}

}
