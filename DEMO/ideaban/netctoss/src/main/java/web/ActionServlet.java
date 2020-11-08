package web;

import dao.CostDAO;
import entity.Cost;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 1. 此 Servlet 处理项目所有的请求，充当控制器 Controller
 * 2. 处理需要响应的数据，并转发给对应的 JSP 处理。
 * @author: Peter
 * @date: 2020/10/3 23:07
 */
public class ActionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 统一设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        // 判断请求路径
        // 因为分模块处理( /cost/list.do )，因此需要判断 uri 中模块部分的路径，所以此处采用字符串匹配除去`项目部署名`路径后的全路径。
        String uri = req.getRequestURI();
        System.out.println("完整 URI："+ uri);
        // req.getContextPath() 获取到的是项目部署名路径
        uri = uri.replace(req.getContextPath(),"");
        System.out.println("截取后的 URI："+ uri);
        System.out.println("项目部署名："+ req.getContextPath());

        if ("/cost/list.do".equals(uri)){
            // 资费查询
            findCost(req, resp);
        }



    }


    /**
     * 查询资费
     * @param req
     * @param resp
     */
    protected void findCost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CostDAO dao = new CostDAO();
        try {
            List<Cost> costs = dao.findAll();
            req.setAttribute("costs", costs);
            // 将请求转发给 jsp
            // 当前路径：/netctoss/cost/list.do
            // 目标：/netctoss/WEB-INF/cost/cost_list.jsp
            req.getRequestDispatcher("../WEB-INF/cost/cost_list.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("err_msg", "数据查询异常！");
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
