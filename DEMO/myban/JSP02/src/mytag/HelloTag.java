package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 自定义标签：
 * 用来输出指定次数的Hello
 * @author Administrator
 *
 */
public class HelloTag extends SimpleTagSupport {
	//用来接收指定的属性值
	private int count;//指定次数
	private String info;//指定的字符串
	@Override
	public void doTag() throws JspException, IOException {
		PageContext ctx = (PageContext) getJspContext();//获取页面上下文对象
		JspWriter out = ctx.getOut();//获取输出流
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
