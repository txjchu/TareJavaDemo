package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���۹��ܵ�Servlet
 * @author Administrator
 *
 */
public class CommentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		String uri = req.getRequestURI();
		System.out.println("uri:"+ uri);
		if(uri.equals("/JSP05/comment")){
//			req.getRequestDispatcher("comment.jsp").forward(req, res);//ת����jsp�ļ�
			out.println("<h1>��˵�Ĳ���Ҳû����ܺã�</h1>");
			
		} else if(uri.equals("/JSP05/comment.do")){
		}else {
			out.print("<h1>��ַ�������������comment</h1>");
		}
	}
	
}
