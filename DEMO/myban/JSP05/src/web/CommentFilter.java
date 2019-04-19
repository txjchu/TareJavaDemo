package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter{
	private FilterConfig config;
	@Override
	public void destroy() {
		System.out.println("destroy:���������ڱ�������...");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		String comment = req.getParameter("comment");//��ȡ���ύ���������� 
		String str = config.getInitParameter("illegalStr");//��ȡxml�����еĹ��������õ�����
		System.out.println("str:"+ str +"; comment:"+ comment);
		if(comment.indexOf(str) != -1){
			//��������
			req.setAttribute("illegal", "�������֣�");//���������󶨷�������
			out.print("<h1>�㽲����</h1>"+ req.getAttribute("illegal"));
//			req.getRequestDispatcher("comment.jsp").forward(req, res);//����ת����ȥ
		} else {
			//û�������ֵ�
			System.out.println("commentFilterִ����ϣ�");
			fc.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		config = cfg;
		System.out.println("init:���������ڳ�ʼ����...config=:"+ config);
		
	}
	
}
