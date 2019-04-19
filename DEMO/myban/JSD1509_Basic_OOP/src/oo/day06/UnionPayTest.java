package oo.day06;
//银行卡系统
public class UnionPayTest {
	public static void main(String[] args) {
		
		ABCATM atm=new ABCATM();
		UnionPay card=new ABCImpl();//银联卡--农行卡
		atm.insertCard(card);//插卡
		atm.payTelBill();
	}
}
/*
 * 农行的ATM机系统：
 * 1.什么银行卡都能插
 * 2.只有农行卡才能支付电话费
 * 
 */


class ABCATM{//农行ATM机
	private UnionPay card;//银联卡
	public void insertCard(UnionPay card){//插入银联卡
		this.card=card;
	} 
	public void payTelBill(){//支付电话费按钮
		if(card instanceof ABC){//是农行卡
			ABC abcCard=(ABC)card;//强制转换为农行卡
			abcCard.payTelBill("12345678912", 200);
		}else{
			System.out.println("不是农行卡，不能支付话费");
		}
	}
	}



interface UnionPay{//银联接口
	public double getBalance();//查询余额
	public boolean drawMoney(double number);//取钱
	public boolean checkPwd(String input);//验证密码
}

interface ABC extends UnionPay{//农业接口
	public boolean payTelBill(String phoneNum,double sum);//支付电话费		
}

class ABCImpl implements ABC{
	
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public boolean payTelBill(String phoneNum,double num){
		System.out.println("支付电话费成功");//--------------------
		return true;
}
}

interface ICBC extends UnionPay{//工行接口
	public void payOline(double number);//在线支付
}
	
class ICBCImpl implements ICBC{
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public void payOline(double number){} 
}




