package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import dao.UserDao;

import entity.Employee;
import entity.User;

/**
 * 服务器类
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		//获取请求的资源路径
		String uri = req.getRequestURI();
		//截取资源路径中间除去应用名以外的部分
		String action = uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf("."));
		System.out.println("请求过来了吗？ActionServlet中的action"+ action);
		EmployeeDao dao = new EmployeeDao();
		//判断获取到的路径，开始分发任务
		if(action.equals("list")){//查询所有记录
			try {
				List<Employee> emps = dao.findAll();
				req.setAttribute("emps", emps);//将emps放入req请求对象中
//				System.out.println(emps);
				req.getRequestDispatcher("listEmp.jsp").forward(req, res);//转发到动态jsp页面
			} catch (Exception e) {
				e.printStackTrace();
				//编程式异常，直接在程序中进行转发到异常页面处理
				req.setAttribute("err_mgr", "系统出错，请重试！");
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
		} else if(action.equals("add")){//添加员工
			String name = req.getParameter("name");
			double salary = Double.parseDouble(req.getParameter("salary"));
			int age = Integer.parseInt(req.getParameter("age"));
			Employee emp = new Employee();
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			//=======
			System.out.println(emp);
			try {
				dao.save(emp);
				res.sendRedirect("list.do");
			} catch (SQLException e) {
				e.printStackTrace();
				//异常处理2.声明式处理异常，将异常抛给容器，容器根据配置响应回动态页面
				throw new ServletException(e);
			}
		} else if(action.equals("delete")){//删除员工
			PrintWriter out = res.getWriter();//========获取输出流
			int id =  Integer.parseInt(req.getParameter("id"));
			try {
				dao.delete(id);
				res.sendRedirect("list.do");
				
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("<h1>删除失败！</h1>");
			}
			
		} else if(action.equals("update")){//修改员工信息
//			Employee emp = req.getParameter("emp");//getParameter()方法获取到的是String类型数据。
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			double salary = Double.parseDouble(req.getParameter("salary"));
			int age = Integer.parseInt(req.getParameter("age"));
			Employee emp = new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			PrintWriter out = res.getWriter();//========获取输出流
			try {
				dao.modify(emp);//调用Dao中修改员工方法
				res.sendRedirect("list.do");//修改完，继续返回list界面
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("<h1>修改失败！</h1>");
			}
		} else if(action.equals("load")){//列表页，点击修改按钮，需要进入修改员工信息页，修改信息页需要预先填充要修改的员工的信息，因此必须将要修改的员工的信息取出，并传给修改员工列。此处调用dao的findById方法，从list页获取员工id，然后查找出来，转发给updateEmp页面。
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				Employee emp = dao.findById(id);
				req.setAttribute("emp", emp);
				req.getRequestDispatcher("updateEmp.jsp").forward(req, res);
			} catch (SQLException e) {
				System.out.println("id查找员工异常");
				e.printStackTrace();
			}
		} else if(action.equals("login")){//登录功能
			String userName = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			UserDao userDao = new UserDao();
			try {
				User u = userDao.findByUserName(userName);//根据用户名通过dao查询实体记录
				if(userName.equals("") || pwd.equals("")){//若用户名没有输入
					req.setAttribute("login_err", "用户名或密码不能为空");
					req.getRequestDispatcher("login.jsp").forward(req, res);
				} else if(u == null || !u.getPwd().equals(pwd)){//若无记录，或实体的密码与输入的密码不等
					req.setAttribute("login_err", "用户名或密码错误");
					req.getRequestDispatcher("login.jsp").forward(req, res);					
				} else {//若用户名和密码正确
					res.sendRedirect("list.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		} else if(action.equals("regist")){//注册用户
			UserDao userDao = new UserDao();
			
			//1.获取表单中的用户名等信息
			String userName = req.getParameter("username");//username
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			String gender = req.getParameter("sex");
//			out.print("alert('"+ userName +"')");
//			System.out.println("userName:"+ userName +".");
			try {
				if (!userName.equals("")) {//用户名不能为空，此处不能写null，因为获取的是字符串，字符串并没有null
					//2.根据用户名查询数据表中的实体
					User u = userDao.findByUserName(userName);
					//3.判断等于该用户名的表中实体记录是否存为Null
					if (u != null) {//用户已经存在
						//5.不等于空，则绑定提示信息后跳转
						req.setAttribute("regis_err", "用户名已经存在");
						req.getRequestDispatcher("regist.jsp")
								.forward(req, res);
					} else {//该用户名尚未注册
						if (check(req, res)) {//判断验证码是否正确
							//4.等于Null则执行插入
							u = new User();
							u.setUserName(userName);
							u.setName(name);
							u.setPwd(pwd);
							u.setGender(gender);
							userDao.save(u);
							res.sendRedirect("login.jsp");//创建账号成功，则重定向到登录界面
						} else {//若验证码输入不正确
							req.setAttribute("regis_err", "验证码输入错误");
							req.getRequestDispatcher("regist.jsp")
									.forward(req, res);
						}
					}
				} else {
					//若用户名为空，则返回并提示
					req.setAttribute("regis_err", "用户名不能为空");
					req.getRequestDispatcher("regist.jsp")
							.forward(req, res);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		} else if(action.equals("toRegist")){//需要注册账号，则重定向去注册页面
			res.sendRedirect("regist.jsp");//重定向
		} else if(action.equals("toLogin")){
			req.getRequestDispatcher("login.jsp").forward(req, res);
		} else if(action.equals("code")){
			ValidateCode vcode = new ValidateCode();
			vcode.service(req, res);
		}
		
		
	}
	
	//检查验证码是否正确的方法
	protected boolean check(HttpServletRequest req, HttpServletResponse res){
		boolean flag = false;
		HttpSession session = req.getSession();
		String code = (String) session.getAttribute("code");
		String vcode = req.getParameter("vcode");
		System.out.println("code:"+ code +";vcode:"+ vcode);
		if(vcode.toUpperCase().equals(code)){//若验证码输入正确
			flag = true;
		}	
		return flag;
	}
	
	
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		try {
			User user = dao.findByUserName("zhang");
			System.out.println(user);
			List<User> users = dao.findAll();
			for(User u : users){
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}














