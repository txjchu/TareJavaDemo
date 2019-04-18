package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *	自定义标签类：用来输出系统时间。
 */
public class SysDateTag 
	extends SimpleTagSupport {
	
	//日期的格式
	private String format = 
		"yyyy-MM-dd HH:mm:ss";
	
	public String getFormat() {
		return format;
	}

	//标签通过此方法，可以替换格式
	public void setFormat(String format) {
		this.format = format;
	}

	//该方法在JSP执行时被调用，
	//用来向浏览器输出数据。
	@Override
	public void doTag() 
		throws JspException, IOException {
		//创建系统时间
		Date date = new Date();
		//格式化为字符串
		SimpleDateFormat fmt = 
			new SimpleDateFormat(format);
		String now = fmt.format(date);
		//输出时间
		PageContext ctx = 
			(PageContext) getJspContext();
		JspWriter w = ctx.getOut();
		w.println(now);
		//不要在此关闭writer，因为JSP上不仅仅使用
		//当前标签，也会使用其他标签，若关闭了
		//writer会影响它使用别的标签。
	}
	

}






