package day05.copy;

public class Test {
	
	//取款
	public boolean getMoney(int money){
		int count = getCount();
		if(money <= count){
			count = count - money;
			saveCount(count);
			return true;
		}
		return false;
	}
	
	//存款
	public void saveCount(int count){		
	}
	
	//查询
	public int getCount(){
		return 0;
	}
}
