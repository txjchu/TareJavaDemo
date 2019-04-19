package web;
/**
 * ��ʾ����������������ʶrequest��ʼ�������ٵ��¼���
 * 		���������ļ��������Լ���session,ServletContext����ĳ�ʼ���������¼���
 * 		Ҳ���Լ���request��session,ServletContext���ݱ仯���¼���
 * 		���еļ��������÷���һ���� �˴�ֻ��ʾServletRequestListener��
 */
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {
	
	//����request����
	@Override
	public void requestDestroyed(ServletRequestEvent e) {
		System.out.println("����request������");
		e.getServletRequest();
		e.getServletContext();
		
	}
	
	//����request��ʼ��
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("��ʼ��request������");

	}

}
