package life;

public class LifeBean {

	public LifeBean() {
		System.out.println("LifeBean's ������...");
	}
	
	public void init(){
		System.out.println("LifeBean's init����...");
	}
	
	public void service(){
		System.out.println("LifeBean's service����...");
	}
	
	public void destroy(){
		System.out.println("LifeBean's destroy����...");
	}
}
