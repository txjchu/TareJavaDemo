package demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 修改 Emp 记录第一步，通过要修改记录的 id 获取到该记录的原来的数据 LoadEmpServlet
 * @author: Peter
 * @date: 2020/9/19 3:44
 */
public class LoadEmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // 定义连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 获取请求中的参数 id
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            conn = JDBCUtil.openConnection();
            // 根据获取到的 id 查询要删除的记录原来的数据
            ps = conn.prepareStatement("SELECT * FROM t_emp WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
//            System.out.println(rs.next()); // 当 rs 调用 next() 方法后，rs 的指针下移一行记录，此处查询出1条结果
            out.println("<html><head></head><body style='font-size:30px'>");
            // 将查询到的数据输出到页面
            if(rs.next()){
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int age = rs.getInt("age");
                int eid = rs.getInt("id");
                out.print("<form action='modify' method='post'>");
                out.print("编号："+ id +"<br>");
                out.print("<input type='hidden' name='id' value='"+ id +"'/><br>");
                out.print("姓名：<input name='name' value='"+ name +"'/><br>");
                out.print("薪水：<input name='salary' value='"+ salary +"'/><br>");
                out.print("年龄：<input name='age' value='"+ age +"'/><br>");
                out.print("<input type='submit' value='修改'/>");
                out.print("</form>");
            }
            out.print("</body></html>");

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
