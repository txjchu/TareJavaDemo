package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Struts2�е���������ϰ
 *	--��Ҫʵ��Interceptor�ӿڣ���ʵ��intercepte������
 * @author Administrator
 */
public class FirstInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("-->FirstInterceptor:������ǰ�ö���...[ǰ��]");
		ai.invoke();	//����������������ش��������Action�е�ҵ�񷽷�
		System.out.println("-->FirstInterceptor:���������ö���...[����]");
		return "error";
	}
	
	
}
