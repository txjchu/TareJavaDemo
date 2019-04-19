package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 再试一次案例
 * @author Administrator
 *
 */
public class HiServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");//告知浏览器是什么类型的文件
		res.setCharacterEncoding("utf-8");//告知浏览器是是什么类型的字符集
		//1.获取输出流
		PrintWriter pw = res.getWriter();//从响应对象中获取输出流
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String now = sdf.format(date);
		//2.向浏览器输出信息
		pw.println("<input type='text' value = 'Hi,'>" +
					"<p>now:"+ now +"</p>");
		pw.close();
	}
	
}
