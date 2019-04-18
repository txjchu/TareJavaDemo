package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *	�Զ����ǩ�ࣺ�������ϵͳʱ�䡣
 */
public class SysDateTag 
	extends SimpleTagSupport {
	
	//���ڵĸ�ʽ
	private String format = 
		"yyyy-MM-dd HH:mm:ss";
	
	public String getFormat() {
		return format;
	}

	//��ǩͨ���˷����������滻��ʽ
	public void setFormat(String format) {
		this.format = format;
	}

	//�÷�����JSPִ��ʱ�����ã�
	//�����������������ݡ�
	@Override
	public void doTag() 
		throws JspException, IOException {
		//����ϵͳʱ��
		Date date = new Date();
		//��ʽ��Ϊ�ַ���
		SimpleDateFormat fmt = 
			new SimpleDateFormat(format);
		String now = fmt.format(date);
		//���ʱ��
		PageContext ctx = 
			(PageContext) getJspContext();
		JspWriter w = ctx.getOut();
		w.println(now);
		//��Ҫ�ڴ˹ر�writer����ΪJSP�ϲ�����ʹ��
		//��ǰ��ǩ��Ҳ��ʹ��������ǩ�����ر���
		//writer��Ӱ����ʹ�ñ�ı�ǩ��
	}
	

}






