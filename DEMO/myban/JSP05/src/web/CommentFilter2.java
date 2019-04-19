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
 * 案例：过滤器2：用来限制评论的字数，如果超过20个字符则不允许发布并提示
 * @author Administrator
 *
 */
public class CommentFilter2 implements Filter{
	private FilterConfig config;
	
	@Override
	public void destroy() {
		System.out.println("CF2被销毁了!");
		
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
		int size = Integer.parseInt(config.getInitParameter("size"));
		if(comment.length() > size){//若超过20个字符
			req.setAttribute("length", "你讲太多了！");
			out.println("评论不成功" +","+ req.getAttribute("length"));
//			req.getRequestDispatcher("/JSP05/comment").forward(req, res);
		} else {
			System.out.println("filter2检测正常！");
			fc.doFilter(req, res);//调用过滤器链的下一个过滤器
		}
		
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		//参数在该方法调用完毕后就会被消除。但是还需使用FilterConfig对象，所以可以将其传送到过滤器对象的属性中，只要过滤器对象在，config就在。
		config = cfg;
	}
	
	
	
}
