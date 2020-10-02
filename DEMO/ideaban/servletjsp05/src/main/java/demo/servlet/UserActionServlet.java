package demo.servlet;

import demo.dao.UserDAO;
import demo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 整合处理 User 类的请求。
 * day05 CASE04
 *
 * User 的 Servlet 其实是包含在 EmpActionServlet 中处理 regist 和 login 2个请求。
 *
 * @author: Peter
 * @date: 2020/9/24 22:39
 */
public class UserActionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        UserDAO dao = new UserDAO();

        String uri = req.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf("."));// 获取 .do 之前的有效请求路径

        // 分发请求
        if("listUser".equals(action)){ // 查询员工信息列表
            try {
                List<User> users = dao.findAll();
                req.setAttribute("users", users);
                req.getRequestDispatcher("listUser.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                // 编程式处理异常
                req.setAttribute("err_msg", "系统出错，请重试！");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }

        } else if("addUser".equals(action)){ // 添加员工(直接从 addUser.jsp 将数据发送到本 Servlet 中后，接收并保存)
            String username = req.getParameter("username");
            String pwd = req.getParameter("pwd");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            User user = new User();
            user.setUserName(username);
            user.setPwd(pwd);
            user.setName(name);
            user.setGender(gender);
            try {
                dao.save(user);
                resp.sendRedirect("listUser.action");
            } catch (SQLException e) {
                req.setAttribute("err_msg", "添加用户记录出错！");
                e.printStackTrace();
                throw new ServletException(e);
            }

        } else if ("deleteUser".equals(action)){ // 删除员工(根据删除请求发送过来的id，删除记录)
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                dao.delete(id);
                resp.sendRedirect("listUser.action");
            } catch (SQLException e) {
                req.setAttribute("err_msg", "删除用户记录出错！");
                e.printStackTrace();
                throw new ServletException(e);
            }

        } else if ("loadUser".equals(action)){ // 加载某个员工，根据 ID
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                User user = dao.findById(id);
                req.setAttribute("user", user);
                req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
            } catch (SQLException e) {
                req.setAttribute("err_msg", "加载用户信息出错！");
                e.printStackTrace();
                throw new ServletException(e);
            }
        } else if ("updateUser".equals(action)){ // 更新某个员工信息
            String username = req.getParameter("username");
            String pwd = req.getParameter("pwd");
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            int id = Integer.parseInt(req.getParameter("id"));
            User user = new User();
            user.setId(id);
            user.setUserName(username);
            user.setPwd(pwd);
            user.setName(name);
            user.setGender(gender);
            try {
                dao.update(user);
                resp.sendRedirect("listUser.action");
            } catch (SQLException e) {
                req.setAttribute("err_msg", "更新用户记录出错！");
                e.printStackTrace();
                throw new ServletException(e);
            }
        } else if ("registUser".equals(action)){ // 注册新员工
            // 用户注册
            UserDAO userDAO = new UserDAO();
            String userName = req.getParameter("username");
            String pwd = req.getParameter("pwd");
            String name = req.getParameter("name");
            String gender = req.getParameter("sex");
            try {
                User user = userDAO.findByUserName(userName); // 注册时，先验证 userName 是否已经存在
                if (user != null){
                    req.setAttribute("regist_msg", "用户名已经存在！");
                    req.getRequestDispatcher("regist.jsp").forward(req, resp); // 转发回 regist.jsp
                } else {
                    user = new User();
                    user.setUserName(userName);
                    user.setName(name);
                    user.setPwd(pwd);
                    user.setGender(gender);
                    userDAO.save(user);
                    req.setAttribute("regist_msg", "注册成功！");
                    resp.sendRedirect("login.jsp");  // 注册成功后重定向到登录页面 login.jsp
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        } else if ("loginUser".equals(action)){ // 员工登录

        }

    }
}
