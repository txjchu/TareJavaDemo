package demo.account;

import demo.dao.AccountDAO;
import demo.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * 整合所有 Servlet 到一个组件中，用来处理 Accont 相关的业务请求。
 * @author: Peter
 * @date: 2020/9/22 20:18
 */
public class ActionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取请求路径
        String uri = req.getRequestURI();
        System.out.println(uri);
        String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        AccountDAO dao = new AccountDAO();

        // 分发请求
        if("list".equals(action)){
            try {
                List<Account> accounts = dao.findAll();
                out.println("<table table border='1' cellpadding='0' cellspacing='0' width='60%'>");
                out.println("<caption>帐务帐号信息列表</caption>"); // 标题,字幕,说明
                out.println("<tr><td>ID</td><td>姓名</td><td>身份证号</td><td>登录名</td>"
                        + "<td>状态</td><td>手机号</td><td>操作</td></tr>");
                for(Account account : accounts){
                    out.print("<tr>");
                    String strStatus = "";
                    if ("1".equals(account.getStatus())){
                        strStatus = "暂停";
                    } else if ("2".equals(account.getStatus())){
                        strStatus = "删除";
                    } else {
                        strStatus = "开通";
                    }
                    out.println("<tr><td>" + account.getAccountId()
                            + "</td><td>" + account.getRealName() + "</td><td>"
                            + account.getIdcardNo() + "</td><td>"
                            + account.getLoginName() + "</td><td>" + strStatus
                            + "</td><td>" + account.getTelephone() + "</td>");
                    out.println("<td><a href='delete.do?accountId="
                            + account.getAccountId() + "' "
                            + "onclick=\"return confirm('是否确定删除"
                            + account.getRealName() + "');\">删除</a>");
                    out.println("<a href='load.do?accountId=" + account.getAccountId()
                            + "'>修改</a></td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<a href='addAccount.html'>增加帐务帐号</a>");

            } catch (SQLException e) {
                e.printStackTrace();
                out.print("系统繁忙！");
            }
        } else if ("add".equals(action)){
            Account account = new Account();
            String loginName = req.getParameter("loginName");
            String status = req.getParameter("status");  //
            String idcardNo = req.getParameter("idcardNo");
            String realName = req.getParameter("realName");
            String telephone = req.getParameter("telephone");

            try {
                account.setLoginName(loginName);
                account.setStatus("0");
                account.setRealName(realName);
                account.setIdcardNo(idcardNo);
                account.setTelephone(telephone);
                dao.save(account);
                resp.sendRedirect("list.do"); // 添加成功则返回 list 页面
            } catch (SQLException e) {
                out.println("系统繁忙！");
                e.printStackTrace();
            }
        } else if ("delete".equals(action)){
            try {
                int id = Integer.parseInt(req.getParameter("accountId"));
                dao.delete(id);
                resp.sendRedirect("list.do");
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("系统繁忙！");
            }
        } else if ("load".equals(action)){
            try {
                String accountId = req.getParameter("accountId");
                Account account = null;
                account = dao.findById(Integer.parseInt(accountId));
                out.println("<html><head></head><body style='font-size:30px'>");
                if(account != null){
                    out.println("<form action='modify.do' method='post'>");
                    out.println("编号："+ account.getAccountId() +"<br>");
                    out.println("<input type='hidden' name='accountId' value='"+ account.getAccountId() + "'/><br>");
                    out.println("姓名:<input name='realName' value='"+ account.getRealName() + "'/><br>");
                    out.println("身份证:<input name='idcardNo' value='"+ account.getIdcardNo() + "'/><br>");
                    out.println("登录名:<input name='loginName' value='"+ account.getLoginName() + "'/><br>");
                    out.println("手机号:<input name='telephone' value='"+ account.getTelephone() + "'/><br>");
                    out.println("<input type='submit' value='修改'/>");
                    out.println("</form>");
                }
                out.println("</body></html>");
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("系统繁忙！");
            }

        } else if ("modify".equals(action)){
            Account account = new Account();
            try {
                int accountId = Integer.parseInt(req.getParameter("accountId"));
                String loginName = req.getParameter("loginName");
                String realName = req.getParameter("realName");
                String idcardNo = req.getParameter("idcardNo");
                String telephone = req.getParameter("telephone");
                account.setAccountId(accountId);
                account.setLoginName(loginName);
                account.setIdcardNo(idcardNo);
                account.setRealName(realName);
                account.setTelephone(telephone);
                dao.modify(account);
                resp.sendRedirect("list.do");
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("系统繁忙！");
            }
        }
        out.close();
    }
}
