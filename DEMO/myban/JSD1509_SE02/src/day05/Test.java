package day05;

public class Test {
	
	//ȡ��
	public boolean getMoney(int money){
		//��ȡ�˻����
		int count = getCount();
		if(money <= count){
			count = count - money;
			saveCount(count);
			return true;//ȡ��ɹ�
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
