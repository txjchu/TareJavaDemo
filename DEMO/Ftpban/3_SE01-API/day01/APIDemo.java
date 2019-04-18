package day01;
/**
 * 文档注释
 * 文档注释可以用来说明类，常量，方法
 * 然后通过java提供的命令javadoc将
 * 内容生成为一个手册。
 * @author Administrator
 * @version 1.0,26/10/15
 * @see java.lang.String
 * @since JDK1.0
 */
public class APIDemo {
	/**
	 * 问候短语,sayHello中使用
	 */
	public static final String INFO="你好!";
	/**
	 * 为指定的用户添加一个问候语
	 * @param name 要添加问候语的用户名
	 * @return 问候语
	 */
	public static String sayHello(String name){
		return INFO+name;
	}
}








