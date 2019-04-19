package day05;

public class Test {
	
	//取款
	public boolean getMoney(int money){
		//获取账户余额
		int count = getCount();
		if(money <= count){
			count = count - money;
			saveCount(count);
			return true;//取款成功
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
