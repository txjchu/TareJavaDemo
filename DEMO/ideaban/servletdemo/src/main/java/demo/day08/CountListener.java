package demo.day08;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器练习
 *
 * 兼听 session 的创建与销毁，实现对当前在线人数的统计。
 * @author: Peter
 * @date: 2020/11/16 22:04
 */
public class CountListener implements HttpSessionListener {

    // 计数器
    private int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count ++; // 每创建1个新的session，说明有1个新用户通过客户端访问服务器
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sct = session.getServletContext();
        sct.setAttribute("count", count);// 将计数器绑定到 ServletContext 上下文对象中，因为上下文对象的作用域是容器的该服务中。
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count --; // 每销毁1个 session， 说明有1个用户登出
        setCount(httpSessionEvent, count);
    }

    public void setCount(HttpSessionEvent httpSessionEvent, int count){
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sct = session.getServletContext();
        sct.setAttribute("count", count);
    }
}
