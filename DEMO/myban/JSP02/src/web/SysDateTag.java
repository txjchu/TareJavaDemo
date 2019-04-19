package web;
/**
 * 演示：自定义标签类，用来输出系统时间。
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysDateTag extends SimpleTagSupport {
	//日期的格式----写一个成员
	//此属性成员为标签中的可以定义的Attribute的属性名，当标签中给该属性赋值value时，则通过get方法实例化该成员。
	private String format ;//= "yyyy-MM-dd E HH-mm-ss"

	
	//该方法在JSP 执行时Servlet时被调用。用来向浏览器输出数据。
	//@Override doTag()
	public void doTag() throws JspException, IOException {
		
		
		
		//创建系统事件
		Date date = new Date();
		//格式化为字符串
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		String now = fmt.format(date);
		//输出时间----JSP内置对象，标签里有，是JSP的管家，可以获取另外8个对象。
		PageContext ctx = (PageContext)getJspContext();
		JspWriter w = ctx.getOut();
		w.println(now);
		//不要在此关闭writer,因为JSP上不仅仅使用当前标签，也会使用其他标签，若关闭了writer会影响它使用别的标签。
	}

	//创建成员的get-set方法
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
