package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * �Զ����ǩ��
 * �������ָ��������Hello
 * @author Administrator
 *
 */
public class HelloTag extends SimpleTagSupport {
	//��������ָ��������ֵ
	private int count;//ָ������
	private String info;//ָ�����ַ���
	@Override
	public void doTag() throws JspException, IOException {
		PageContext ctx = (PageContext) getJspContext();//��ȡҳ�������Ķ���
		JspWriter out = ctx.getOut();//��ȡ�����
		for(int i = 0; i < count; i++){
			out.println(info +"<br/>");
		}		
	}
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
