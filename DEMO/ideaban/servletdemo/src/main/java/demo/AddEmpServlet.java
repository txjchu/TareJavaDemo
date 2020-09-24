package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: Peter
 * @date: 2020/9/16 18:22
 */
public class AddEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置中文的输入和输出
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        // 获取表单提交的数据
        String name = req.getParameter("name");
        double salary = Double.valueOf(req.getParameter("salary"));
        int age = Integer.valueOf(req.getParameter("age"));
        // 获取输出流对象，并输出信息
        PrintWriter out = resp.getWriter();

        /*
         * 直接输出到客户端
         */
        /*
        out.print("<h1>员工信息</h1>");
        out.print("<h1>姓名："+ name +"</h1>");
        out.print("<h1>薪水："+ salary +"</h1>");
        out.print("<h1>年龄："+ age +"</h1>");
        */

        /*
         * 使用 JDBC 添加员工信息
         */
        // 创建 JDBC 连接
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            /*
             * 注意：本地 MySQL 版本为 8.0，因此 MySQL 驱动需要版本高些的。8.0.11版的驱动名称有变化
             */
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");
        } catch (Exception e) {
            System.out.println("数据库加载异常！");
            e.printStackTrace();
        }
        try {
            /*
             * 注意高版本 MySQL 驱动连接 URL 的拼接中需要注意 SSL、serverTimezone(GMT%2B8 -> GMT+8) 的设置
             */
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lianxishujuku?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","1234");// 连接本地数据库
            System.out.println("数据库连接成功！");
        } catch (SQLException e) {
            System.out.println("数据库连接异常！");
            e.printStackTrace();
        }
        try {
            ps = conn.prepareStatement("insert into t_emp values(null, ?, ?, ?)"); // 设置 SQL 语句，并留空参数
            ps.setString(1, name); // 根据数据替换参数
            ps.setDouble(2, salary);
            ps.setInt(3, age);
            ps.executeUpdate();// 执行
            out.print("添加成功！");
        } catch (SQLException e) {
            System.out.println("数据插入异常！");
            e.printStackTrace();
        } finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        out.close();

    }
}
