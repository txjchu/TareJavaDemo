package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {
	
	//����һ��Ĭ�Ϲ�����----��ʾ��ʱ����
	public FirstFilter(){
		System.out.println("����FirstFilter");
	}
	
	//
	@Override
	public void destroy() {
		System.out.println("����FirstFilter");

	}
	
	//���˷���������������ʼ�׶ι�������Ҳ��������������׶ι�����Ӧ����������ʵ���������Ӧ��˫����ˡ�
	//���ˣ������������дʡ���¼��־��Ȩ�޼�顢�ȣ����Դ���һ��Servlet��ͨ�õ�ҵ��
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//��������Ĵ���
		System.out.println("����ҵ�񷽷�FirstFilter��������");
		/**
		 * chain:������
		 * doFilter�����ǵݹ������һ��Filter��ͨ��ÿ��Filter�ж������chain.doFilter(),�����ݹ�ĵ�����ȥ��ֱ�����һ��FilterΪֹ��
		 * ����������һ��Filter���������û��дdoFilter()���������Ͷ��ˣ��������жϡ��Ͳ���ִ�Servlet��
		 *	 ���е�Fileter�������꣬�ͻ����Servlet.
		 * 
		 */
		chain.doFilter(req,res);
		//������Ӧ�Ĵ���
		System.out.println("FirstFilter��ʼ������Ӧ");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ��FirstFilter");
	}

}
