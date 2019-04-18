package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//通过ServletContext获取预置的数据(全局)
		ServletContext ctx = getServletContext();
		String max = 
			ctx.getInitParameter("maxOnline");
		System.out.println(max);
		
		//统计流量，输出给浏览器
		Object count = ctx.getAttribute("count");
		if(count == null) {
			//第一次请求时没有count，
			//我们将其设置为1。
			ctx.setAttribute("count", 1);
		} else {
			//不是第一次请求时有count，
			//取出count，+1，再设置count。
			ctx.setAttribute("count", 
				new Integer(count.toString())+1);
		}
		
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("总流量为：" 
			+ ctx.getAttribute("count"));
		w.close();		
	}

	
}




