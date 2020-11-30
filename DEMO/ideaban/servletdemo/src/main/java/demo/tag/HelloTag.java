package demo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 练习自定义标签库
 *
 * 创建一个标签库 HelloTag ,必须继承 SimpleTagSupport 类
 * @author: Peter
 * @date: 2020/11/18 19:18
 */
public class HelloTag extends SimpleTagSupport {

    private String str;
    private int count;

    /*
     * 标签动作
     * 新建HelloTag类，继承自SimpleTagSupport类，为了接收页面中指定的参数，需要定义两个属性，并添加get/set方法。
     * 注意：属性名称一定与使用标签时，暴露的属性名称一致。
     * 重写doTag方法，将标签要执行的动作在该方法中进行定义。
     */
    @Override
    public void doTag() throws JspException, IOException {
        PageContext ctx = (PageContext) getJspContext();
        JspWriter out = ctx.getOut();

        for(int i = 0; i < count; i ++){
            out.println(str +"<br>");
        }
    }






    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
