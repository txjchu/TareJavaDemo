package netctoss.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * ��¼��֤�����������ڼ���û��Ƿ��¼
 * @author Administrator
 *
 */
public class LoginInterceptor implements Interceptor{

	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("-->LoginInterceptor�����뵽��¼������ǰ�÷�����...");
		//��ȡsession
		Map<String, Object> session = ai.getInvocationContext().getSession();
		Object admin = session.get("admin");//��ȡ��¼��Ϣ
		if(admin == null){//��û�л�ȡ���û���Ϣ
			return "login";//���ص�¼ҳ��
		} else {
			return ai.invoke();//��ȡ���������ִ�к�������
		}
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
