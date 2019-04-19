package netctoss.interceptor;

import netctoss.util.HibernateUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * OpenSessionInView��������
 * ������Action�����������֮ǰ����Ϊsession���ӳټ����У���ǰ�رպ����ҳ��û�л�ȡ�����ݡ�
 * @author Administrator
 *
 */
public class OpenSessionInViewInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation ai) throws Exception {
		ai.invoke();//ִ����Actionҵ�񷽷������������䷵��ֵ������Result����ʱҳ��Jsp��ʼ��ȡ���ݡ�
		HibernateUtil.close();//��Action��ҵ�񷽷�ִ����ϣ��ٹر�Session
		return null;
	}
	
}
