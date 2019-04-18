package oo.day05;
//银行卡系统
public class UnionPayTest {
	public static void main(String[] args) {
		ABCImpl  card1 = new ABCImpl(); //农行卡
		ABC      card2 = new ABCImpl(); //农行卡---------向上造型
		UnionPay card3 = new ABCImpl(); //银联卡(农行卡)--向上造型
	}
}

interface UnionPay{ //银联接口
	public double getBalance(); //查询余额
	public boolean drawMoney(double number); //取钱
	public boolean checkPwd(String input); //检查密码是否正确
}
interface ICBC extends UnionPay{ //工行接口
	public void payOnline(double number); //在线支付
}
interface ABC extends UnionPay{ //农行接口
	public boolean payTelBill(String phoneNum,double sum); //支付电话费
}
class ICBCImpl implements ICBC{ //工行卡
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public void payOnline(double number){}
}
class ABCImpl implements ABC{ //农行卡
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public boolean payTelBill(String phoneNum,double sum){return true;}
}










