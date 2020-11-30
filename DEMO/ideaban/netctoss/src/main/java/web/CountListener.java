package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器
 * 用来统计系统当前在线访问人数
 * @author: Peter
 * @date: 2020/11/30 18:27
 */
public class CountListener implements HttpSessionListener {

    private int count = 0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count ++;
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sct = session.getServletContext();
        sct.setAttribute("count", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
