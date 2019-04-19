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
 * ��������
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		//��ȡ�������Դ·��
		String uri = req.getRequestURI();
		//��ȡ��Դ·���м��ȥӦ��������Ĳ���
		String action = uri.substring(uri.lastIndexOf("/")+ 1, uri.lastIndexOf("."));
		System.out.println("�����������ActionServlet�е�action"+ action);
		EmployeeDao dao = new EmployeeDao();
		//�жϻ�ȡ����·������ʼ�ַ�����
		if(action.equals("list")){//��ѯ���м�¼
			try {
				List<Employee> emps = dao.findAll();
				req.setAttribute("emps", emps);//��emps����req���������
//				System.out.println(emps);
				req.getRequestDispatcher("listEmp.jsp").forward(req, res);//ת������̬jspҳ��
			} catch (Exception e) {
				e.printStackTrace();
				//���ʽ�쳣��ֱ���ڳ����н���ת�����쳣ҳ�洦��
				req.setAttribute("err_mgr", "ϵͳ���������ԣ�");
				req.getRequestDispatcher("error.jsp").forward(req, res);
			}
		} else if(action.equals("add")){//���Ա��
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
				//�쳣����2.����ʽ�����쳣�����쳣�׸���������������������Ӧ�ض�̬ҳ��
				throw new ServletException(e);
			}
		} else if(action.equals("delete")){//ɾ��Ա��
			PrintWriter out = res.getWriter();//========��ȡ�����
			int id =  Integer.parseInt(req.getParameter("id"));
			try {
				dao.delete(id);
				res.sendRedirect("list.do");
				
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("<h1>ɾ��ʧ�ܣ�</h1>");
			}
			
		} else if(action.equals("update")){//�޸�Ա����Ϣ
//			Employee emp = req.getParameter("emp");//getParameter()������ȡ������String�������ݡ�
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			double salary = Double.parseDouble(req.getParameter("salary"));
			int age = Integer.parseInt(req.getParameter("age"));
			Employee emp = new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setAge(age);
			PrintWriter out = res.getWriter();//========��ȡ�����
			try {
				dao.modify(emp);//����Dao���޸�Ա������
				res.sendRedirect("list.do");//�޸��꣬��������list����
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("<h1>�޸�ʧ�ܣ�</h1>");
			}
		} else if(action.equals("load")){//�б�ҳ������޸İ�ť����Ҫ�����޸�Ա����Ϣҳ���޸���Ϣҳ��ҪԤ�����Ҫ�޸ĵ�Ա������Ϣ����˱��뽫Ҫ�޸ĵ�Ա������Ϣȡ�����������޸�Ա���С��˴�����dao��findById��������listҳ��ȡԱ��id��Ȼ����ҳ�����ת����updateEmpҳ�档
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				Employee emp = dao.findById(id);
				req.setAttribute("emp", emp);
				req.getRequestDispatcher("updateEmp.jsp").forward(req, res);
			} catch (SQLException e) {
				System.out.println("id����Ա���쳣");
				e.printStackTrace();
			}
		} else if(action.equals("login")){//��¼����
			String userName = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			UserDao userDao = new UserDao();
			try {
				User u = userDao.findByUserName(userName);//�����û���ͨ��dao��ѯʵ���¼
				if(userName.equals("") || pwd.equals("")){//���û���û������
					req.setAttribute("login_err", "�û��������벻��Ϊ��");
					req.getRequestDispatcher("login.jsp").forward(req, res);
				} else if(u == null || !u.getPwd().equals(pwd)){//���޼�¼����ʵ�����������������벻��
					req.setAttribute("login_err", "�û������������");
					req.getRequestDispatcher("login.jsp").forward(req, res);					
				} else {//���û�����������ȷ
					res.sendRedirect("list.do");
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		} else if(action.equals("regist")){//ע���û�
			UserDao userDao = new UserDao();
			
			//1.��ȡ���е��û�������Ϣ
			String userName = req.getParameter("username");//username
			String name = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			String gender = req.getParameter("sex");
//			out.print("alert('"+ userName +"')");
//			System.out.println("userName:"+ userName +".");
			try {
				if (!userName.equals("")) {//�û�������Ϊ�գ��˴�����дnull����Ϊ��ȡ�����ַ������ַ�����û��null
					//2.�����û�����ѯ���ݱ��е�ʵ��
					User u = userDao.findByUserName(userName);
					//3.�жϵ��ڸ��û����ı���ʵ���¼�Ƿ��ΪNull
					if (u != null) {//�û��Ѿ�����
						//5.�����ڿգ������ʾ��Ϣ����ת
						req.setAttribute("regis_err", "�û����Ѿ�����");
						req.getRequestDispatcher("regist.jsp")
								.forward(req, res);
					} else {//���û�����δע��
						if (check(req, res)) {//�ж���֤���Ƿ���ȷ
							//4.����Null��ִ�в���
							u = new User();
							u.setUserName(userName);
							u.setName(name);
							u.setPwd(pwd);
							u.setGender(gender);
							userDao.save(u);
							res.sendRedirect("login.jsp");//�����˺ųɹ������ض��򵽵�¼����
						} else {//����֤�����벻��ȷ
							req.setAttribute("regis_err", "��֤���������");
							req.getRequestDispatcher("regist.jsp")
									.forward(req, res);
						}
					}
				} else {
					//���û���Ϊ�գ��򷵻ز���ʾ
					req.setAttribute("regis_err", "�û�������Ϊ��");
					req.getRequestDispatcher("regist.jsp")
							.forward(req, res);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		} else if(action.equals("toRegist")){//��Ҫע���˺ţ����ض���ȥע��ҳ��
			res.sendRedirect("regist.jsp");//�ض���
		} else if(action.equals("toLogin")){
			req.getRequestDispatcher("login.jsp").forward(req, res);
		} else if(action.equals("code")){
			ValidateCode vcode = new ValidateCode();
			vcode.service(req, res);
		}
		
		
	}
	
	//�����֤���Ƿ���ȷ�ķ���
	protected boolean check(HttpServletRequest req, HttpServletResponse res){
		boolean flag = false;
		HttpSession session = req.getSession();
		String code = (String) session.getAttribute("code");
		String vcode = req.getParameter("vcode");
		System.out.println("code:"+ code +";vcode:"+ vcode);
		if(vcode.toUpperCase().equals(code)){//����֤��������ȷ
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














