package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author: Peter
 * @date: 2020/9/17 3:58
 */
public class ListEmpServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        // 使用 JDBC 操作数据库
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 获取 MySQL 驱动
            System.out.println("获取 MySQL 驱动成功！");
        } catch (ClassNotFoundException e) {
            System.out.println("获取 MySQL 驱动异常！");
            e.printStackTrace();
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lianxishujuku?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","1234");// 连接本地 MySQL 中指定的数据库
            System.out.println("获取连接成功！");
        } catch (SQLException e) {
            System.out.println("获取连接异常！");
            e.printStackTrace();
        }
        try {
            ps = conn.prepareStatement("SELECT * FROM t_emp");// 传入 SQL 语句
            ResultSet rs = ps.executeQuery(); // 获取结果集
            PrintWriter pw = resp.getWriter();
            // 输出表格前页面标记
            pw.print("<HTML>");
            pw.print("<head>");
            pw.print("</head>");
            pw.print("<body>");
            pw.print("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
            pw.println("<caption>员工信息列表</caption>");
            pw.println("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td></tr>");
            // 遍历 resultSet 结果集，并输出到表格中
            while(rs.next()){// 若结果集中还有数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int age = rs.getInt("age");
                pw.print("<tr><td>"+ id +"</td><td>"+ name +"</td><td>"+ salary +"</td><td>"+ age +"</td>");
                pw.print("<td><a href='delete?id="+id+"' " +"onclick=\"return confirm('是否确定删除"+ name +"');\">删除</a></td>");// 删除操作链接
                pw.print("<td><a href='load?id="+ id +"'>修改</a></td>");
                pw.print("</tr>");
            }
            pw.print("</table>");
            pw.print("<a href='addEmp.jsp'>增加员工信息</a>");
            pw.print("</body>");
            pw.print("</HTML>");
            pw.flush(); //
            pw.close();
            System.out.println("操作数据库成功！");
        } catch (SQLException e) {
            System.out.println("操作数据库异常！");
            e.printStackTrace();
        } finally {
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
