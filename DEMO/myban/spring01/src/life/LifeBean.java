package life;

public class LifeBean {

	public LifeBean() {
		System.out.println("LifeBean's 构造器...");
	}
	
	public void init(){
		System.out.println("LifeBean's init方法正在执行...");
	}
	
	public void service(){
		System.out.println("LifeBean's service(服务)方法正在调用...");
	}
	
	public void destroy(){
		System.out.println("LifeBean's destroy的方法正在调用....");
	}
}
