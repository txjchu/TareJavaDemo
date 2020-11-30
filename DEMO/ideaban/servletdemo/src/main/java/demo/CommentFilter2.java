package demo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 练习多个过滤器的执行顺序。
 * 过滤评论的长度，不能超过20个字符。
 * @author: Peter
 * @date: 2020/11/16 18:35
 */
public class CommentFilter2 implements Filter {

    /*
     * 动态设置过滤器的初始化参数，先在 web.xml 中配置，然后在编码中获取，此后的就可以修改配置实现动态配置。
     */
    private int illegalLength;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        illegalLength = Integer.parseInt(filterConfig.getInitParameter("illegalLength"));
        System.out.println(this.getClass().getName()+ ": CommentFilter2 is init...");
        System.out.println(this.getClass().getName() +": illegalLength:"+ illegalLength);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String str = request.getParameter("comment");
        if(str.length() > illegalLength){
            out.println("评论太长，不能超过"+ illegalLength +"个字符！");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
