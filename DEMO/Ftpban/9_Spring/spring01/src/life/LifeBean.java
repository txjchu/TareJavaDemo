package life;

public class LifeBean {

	public LifeBean() {
		System.out.println("LifeBean's 构造器...");
	}
	
	public void init(){
		System.out.println("LifeBean's init方法...");
	}
	
	public void service(){
		System.out.println("LifeBean's service方法...");
	}
	
	public void destroy(){
		System.out.println("LifeBean's destroy方法...");
	}
}
