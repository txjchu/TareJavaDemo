package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//对与post请求，在获取参数前，设置编码
		//为utf-8，即可解决乱码问题。
		req.setCharacterEncoding("utf-8");
		//通过request可以获取请求参数，
		//无论获取单个值，还是多个值，都通过name；
		//返回的参数类型是String/String[]。
		String code = req.getParameter("code");
		//对于get请求中乱码的参数，可以先用iso8859-1
		//还原回byte，再用utf-8将byte编码为String。
//		code = new String(
//			code.getBytes("iso8859-1"), "utf-8");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String[] loves = 
			req.getParameterValues("love");
		//输出参数
		System.out.println(code);
		System.out.println(pwd);
		System.out.println(sex);
		if(loves != null) {
			for(String love : loves) {
				System.out.println(love);
			}
		}
		
		//做出响应
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>注册成功.</h1>");
		w.close();
	}

	
	
	
	
	
}
