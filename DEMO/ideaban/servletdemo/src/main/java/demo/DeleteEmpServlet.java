package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 删除 Emp Servlet
 * @author: Peter
 * @date: 2020/9/19 3:23
 */
public class DeleteEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter out = resp.getWriter();

        // 定义数据库连接
        Connection conn = null;
        PreparedStatement ps = null;

        // 获取请求中的参数 id
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            // 连接数据库，并执行 SQL
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("DELETE FROM t_emp WHERE id = ? ");
            ps.setInt(1, id);
            ps.executeUpdate();
            resp.sendRedirect("list"); // 删除成功后，重定向到 list 页面


        } catch (SQLException e) {
            System.out.println("数据库连接异常！");
            e.printStackTrace();
        } finally {
            if(conn != null){
                JDBCUtil.closeConnection(conn);
            }
        }
    }
}
