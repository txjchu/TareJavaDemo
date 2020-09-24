package demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 学习 servlet 生命周期
 * @author: Peter
 * @date: 2020/9/20 22:31
 */
public class LifeServlet extends HttpServlet {

    // 阶段1：实例化
    public LifeServlet(){
        System.out.println("1. Constructor is running...");
    }
    // 阶段2：初始化
    @Override
    public void init() throws ServletException {
        System.out.println("2. Init is running...");
    }

    // 阶段3：就绪
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取初始化参数
        ServletConfig servletConfig = getServletConfig();
        String org = servletConfig.getInitParameter("org"); // 按照给定的字符串，获取 web.xml 中配置的 init-param中 param-name 相同的 value
        String address = servletConfig.getInitParameter("address");
        System.out.println("3. Service is running...");
        System.out.println("初始参数为：org:"+ org +", address:"+ address);
    }

    // 阶段4. 销毁
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("4. Destroy is running...");
    }

}
