package day05.copy;

public class Test {
	
	//ȡ��
	public boolean getMoney(int money){
		int count = getCount();
		if(money <= count){
			count = count - money;
			saveCount(count);
			return true;
		}
		return false;
	}
	
	//���
	public void saveCount(int count){		
	}
	
	//��ѯ
	public int getCount(){
		return 0;
	}
}
