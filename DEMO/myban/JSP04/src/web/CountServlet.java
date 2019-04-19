package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 通过计算session来计算客户端数量
 * @author Administrator
 *
 */
public class CountServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		//获取session对象
		HttpSession session = req.getSession();
		//输出sessionId
		System.out.println(session.getId());
		//获取绑定计算器，下步判断是否获取到
		Integer count = (Integer) session.getAttribute("count");
		if(count == null){//第一次访问
			count = 1;
		} else {//不是第一次访问
			count ++;
		}
		session.setAttribute("count", count);//给session绑定count
		//输出信息
		out.println("这是第"+ count +"次访问。");
		out.close();
		
			
		
		
		
		
		
		
		
		
	}
	
}
