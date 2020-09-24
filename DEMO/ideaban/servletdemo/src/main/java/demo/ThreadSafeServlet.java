package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 每个Servlet只会创建一个对象实例，多个请求同时访问这个实例时，如果有修改属性的操作，那么就会有线程安全的隐患，也就是说Servlet是线程不安全的。
 * 如何避免：
 * 加锁，synchronized(this){...}
 * @author: Peter
 * @date: 2020/9/21 1:38
 */
public class ThreadSafeServlet extends HttpServlet {
    // 定义一个私有属性
    private int count = 0;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        synchronized (this) { // 锁对象，此处表示当前 servlet
            count ++;
            try {
                Thread.sleep(5000); // 模拟网络延迟5秒，使所有请求处于同一步中
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +":"+ count);
        }
    }
}
