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
		System.out.println("destroy:过滤器现在被销毁了...");
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		String comment = req.getParameter("comment");//获取表单提交过来的内容 
		String str = config.getInitParameter("illegalStr");//获取xml配置中的过滤器配置的属性
		System.out.println("str:"+ str +"; comment:"+ comment);
		if(comment.indexOf(str) != -1){
			//有敏感字
			req.setAttribute("illegal", "有敏感字！");//给请求对象绑定反馈数据
			out.print("<h1>你讲错话了</h1>"+ req.getAttribute("illegal"));
//			req.getRequestDispatcher("comment.jsp").forward(req, res);//继续转发回去
		} else {
			//没有敏感字的
			System.out.println("commentFilter执行完毕！");
			fc.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		config = cfg;
		System.out.println("init:过滤器现在初始化了...config=:"+ config);
		
	}
	
}
