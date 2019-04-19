package web;
/**
 * ��ʾ���Զ����ǩ�࣬�������ϵͳʱ�䡣
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysDateTag extends SimpleTagSupport {
	//���ڵĸ�ʽ----дһ����Ա
	//�����Գ�ԱΪ��ǩ�еĿ��Զ����Attribute��������������ǩ�и������Ը�ֵvalueʱ����ͨ��get����ʵ�����ó�Ա��
	private String format ;//= "yyyy-MM-dd E HH-mm-ss"

	
	//�÷�����JSP ִ��ʱServletʱ�����á������������������ݡ�
	//@Override doTag()
	public void doTag() throws JspException, IOException {
		
		
		
		//����ϵͳ�¼�
		Date date = new Date();
		//��ʽ��Ϊ�ַ���
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		String now = fmt.format(date);
		//���ʱ��----JSP���ö��󣬱�ǩ���У���JSP�Ĺܼң����Ի�ȡ����8������
		PageContext ctx = (PageContext)getJspContext();
		JspWriter w = ctx.getOut();
		w.println(now);
		//��Ҫ�ڴ˹ر�writer,��ΪJSP�ϲ�����ʹ�õ�ǰ��ǩ��Ҳ��ʹ��������ǩ�����ر���writer��Ӱ����ʹ�ñ�ı�ǩ��
	}

	//������Ա��get-set����
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
