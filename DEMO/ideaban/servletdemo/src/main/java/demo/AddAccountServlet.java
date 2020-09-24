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
 * @author: Peter
 * @date: 2020/9/18 5:22
 */
public class AddAccountServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 获取输出对象
        PrintWriter out = resp.getWriter();

        // 获取表单提交的数据
        String realName = req.getParameter("realName");
        String idcardNo = req.getParameter("idcardNo");
        String loginName = req.getParameter("loginName");
        String telephone = req.getParameter("telephone");

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("INSERT INTO account(account_id,login_name,status,real_name,idcard_no,telephone) VALUES(null, ?,?,?,?,?)");
            ps.setString(1, loginName);
            ps.setString(2, "0");// 默认添加创建即开通状态 0
            ps.setString(3, realName);
            ps.setString(4, idcardNo);
            ps.setString(5, telephone);
            ps.executeUpdate();
            out.println("添加成功！");
            out.print("<a href='listAccount'>查看帐务帐号信息列表</a>");

        } catch (SQLException e) {
            System.out.println("系统繁忙请稍后再试!");
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

    }
}
