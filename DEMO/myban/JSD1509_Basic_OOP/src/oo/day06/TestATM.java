package oo.day06;
//ũ��ATM������ϵͳ
import java.util.Scanner;
public class TestATM {
	public static void main(String[] args) {

	}
}

class ABCATM1{
	private UnionPay card;
	public void insertCard(UnionPay userCard){
		if(card==null){
			card=userCard;
		}
	}
	private void outCard(){
		card=null;
	}
	private void showBalance(){		//---ֻ������û�в����ķ���������
		System.out.println("��ǰ����ǣ�"+card.getBalance());
	}
	private void takeMoney(){
		Scanner input=new Scanner(System.in);
		System.out.println("������ȡ����Ŀ");
		double number=Double.parseDouble(input.next());
		if(card.drawMoney(number)){
			System.out.println("ȡ��ɹ�");
		}else{
			System.out.println("ȡ��ʧ��");
		}

	
	
	}
}