package day05;

public class Test {
	public boolean getMoney(int money){
		//ªÒ»°’Àªß”‡∂Ó
		int count = getCount();
		if(money<=count){
			count = count - money;
			saveCount(count);
			return true;
		}
		return false;
		
	}
	public void saveCount(int count){
		
	}
	
	public int getCount(){
		return 0;
	}
}
