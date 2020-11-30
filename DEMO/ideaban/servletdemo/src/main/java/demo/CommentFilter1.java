package demo;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤器练习 day08
 * @author: Peter
 * @date: 2020/11/16 18:02
 */
public class CommentFilter1 implements Filter {

    /*
     * 动态设置过滤器初始化参数
     */
    private String illegalWord;


    /**
     * 容器启动后会创建过滤器实例，然后调用 init 方法，只会调用1次。
     * 容器可恶意将 filterConfing 对象作为参数传入，可以从该参数中获取初始化的配置信息。
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass().getName() +": CommentFilter1 is init....");
        illegalWord = filterConfig.getInitParameter("illegalWord");
        System.out.println(this.getClass().getName() +": IllegalWord:"+ illegalWord);
    }

    /*
     * 用于处理请求的主要方法，做过滤器要做的事情
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter out = servletResponse.getWriter();
        String comment = servletRequest.getParameter("comment");
//        if(comment.indexOf("damn") != -1){ // 验证获取到的评论中是否包含限制词
        if(comment.indexOf(illegalWord) != -1){
            out.println("<h3>评论内容已关闭。</h3>");
        } else {
            // 没有敏感词，则将向后传递处理，交给其他过滤器或者 servlet
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /*
     * 容器删除过滤器之前调用，只调用1次
     */
    @Override
    public void destroy() {

    }
}
