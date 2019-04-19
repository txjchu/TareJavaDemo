package netctoss.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netctoss.entity.Admin;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��¼��֤������
 * ������֤�û�����������ʱ�Ƿ��Ѿ���¼��
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		Admin admin = (Admin) req.getSession().getAttribute("admin");//��ȡ���������session�б����admin����
		
		System.out.println("������������...");
//		System.out.println("����������:"+ admin.getAdminCode() +":"+ admin.getPassword());//�˷��������һ����ָ���쳣����ɽ��뵽���쳣ҳ�棬�Ӷ�û��ִ������Ĵ���
		
		if(admin == null ){//��session��û�б���admin����		|| 1>0
			
			//��ʱ��req.getContextPath()Ϊ��/SpringNetctoss001
			res.sendRedirect(req.getContextPath()+ "/login/toLogin.do");//���ض���ص�¼ҳ��
			return false;//���ҷ���false����ִ�к���Ŀ������еĲ���
		}
		return true;//����֤�ɹ�������true��������������������
	}
	
}
