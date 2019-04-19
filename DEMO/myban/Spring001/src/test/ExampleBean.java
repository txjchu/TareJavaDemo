package test;
/**
 * 演示bean的生命周期
 * @author Administrator
 *
 */
public class ExampleBean {
	//构造器
	public ExampleBean(){
		System.out.println("实例化ExampleBean:"+ this);
	}
	//初始化
	public void init(){
		System.out.println("初始化Bean："+ this);
	}
	//执行某方法
	public void execute(){
		System.out.println("执行Bean中的方法");
	}
	//销毁
	public void destroy(){
		System.out.println("销毁Bean："+ this);
	}
}
