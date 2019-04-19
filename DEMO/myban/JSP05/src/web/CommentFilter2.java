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

/**
 * ������������2�������������۵��������������20���ַ�������������ʾ
 * @author Administrator
 *
 */
public class CommentFilter2 implements Filter{
	private FilterConfig config;
	
	@Override
	public void destroy() {
		System.out.println("CF2��������!");
		
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
		int size = Integer.parseInt(config.getInitParameter("size"));
		if(comment.length() > size){//������20���ַ�
			req.setAttribute("length", "�㽲̫���ˣ�");
			out.println("���۲��ɹ�" +","+ req.getAttribute("length"));
//			req.getRequestDispatcher("/JSP05/comment").forward(req, res);
		} else {
			System.out.println("filter2���������");
			fc.doFilter(req, res);//���ù�����������һ��������
		}
		
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		//�����ڸ÷���������Ϻ�ͻᱻ���������ǻ���ʹ��FilterConfig�������Կ��Խ��䴫�͵�����������������У�ֻҪ�����������ڣ�config���ڡ�
		config = cfg;
	}
	
	
	
}
