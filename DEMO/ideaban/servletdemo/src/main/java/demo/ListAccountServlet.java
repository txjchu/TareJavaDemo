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
 * @author: Peter
 * @date: 2020/9/18 19:23
 */
public class ListAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置输入输出编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        // 获取输出流对象
        PrintWriter out = resp.getWriter();
        // 连接数据库
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            // 1. 创建连接，并执行查询语句，获取 ResultSet
            ps = conn.prepareStatement("SELECT * FROM account");
            rs = ps.executeQuery();
            // 2. 输出表格表头
            out.println("<HTML>");
            out.println("<HEAD></HEAD>");
            out.println("<BODY>");
            out.println("<table border='1' cellpadding='0' cellspacing='0' width='60%'>");
            out.println("<caption>员工信息列表</caption>");
            out.println("<tr><td>ID</td><td>姓名</td><td>身份证号</td><td>登录名</td>" +
                    "<td>状态</td><td>手机号</td></tr>");
            // 3. 遍历结果集，并以表格形式输出
            while (rs.next()){
                int id = rs.getInt("account_id");
                String loginName = rs.getString("login_name");
                String status = rs.getString("status");
                String realName = rs.getString("real_name");
                String idcardNo = rs.getString("idcard_no");
                String telephone = rs.getString("telephone");
                String strStatus = "";
                if("1".equals(status)){
                    strStatus = "暂停";
                } else if("2".equals(status)){
                    strStatus = "删除";
                } else {
                    strStatus = "开通";
                }
                out.print("<tr><td>"+
                        id+"</td><td>"+
                        realName+"</td><td>"+
                        idcardNo+"</td><td>"+
                        loginName+"</td><td>"+
                        strStatus+"</td><td>"+
                        telephone+"</td>");

                out.print("</tr>");

            }
            // 4. 结束
            out.print("</table>");
            out.print("<a href='addAccount.jsp'>添加员工信息</a>");
            out.println("</BODY>");
            out.println("</HTML>");
            out.flush();

        } catch (SQLException e) {
            System.out.println("连接数据库异常！");
            e.printStackTrace();
        } finally {
            if(conn != null){
                JDBCUtil.closeConnection(conn);
            }
            if(out != null){
                out.close();
            }
        }
    }
}
