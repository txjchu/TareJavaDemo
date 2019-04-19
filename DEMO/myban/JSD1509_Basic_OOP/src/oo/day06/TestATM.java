package oo.day06;
//农行ATM机银行系统
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
	private void showBalance(){		//---只有括号没有参数的方法？？？
		System.out.println("当前余额是："+card.getBalance());
	}
	private void takeMoney(){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入取款数目");
		double number=Double.parseDouble(input.next());
		if(card.drawMoney(number)){
			System.out.println("取款成功");
		}else{
			System.out.println("取款失败");
		}

	
	
	}
}