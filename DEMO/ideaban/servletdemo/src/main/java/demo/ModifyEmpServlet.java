package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 修改 Emp 记录第二步，点击修改按钮后，将页面上的数据传到服务器并修改数据库中的记录，最后返回 list 页面
 * @author: Peter
 * @date: 2020/9/19 4:32
 */
public class ModifyEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 1. 获取请求参数
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int age = Integer.parseInt(req.getParameter("age"));

        // 2. 定义数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE t_emp SET name = ?, salary = ?, age = ? WHERE id = ?");
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.executeUpdate(); // 执行修改 SQL
            resp.sendRedirect("list"); // 修改完成后返回 list 页面

        } catch (SQLException e) {
            System.out.println("数据连接异常！");
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
            }
            if(conn != null){
                JDBCUtil.closeConnection(conn);
            }
        }

    }
}
