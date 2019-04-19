package oo.day06;

public class UnionPayTest01 {
	public static void main(String[] args) {
		ABCATM01 atm = new ABCATM01();
		UnionPay1 card = new ABCImpl1(2000,"123");
		atm.insertCard(card);
		atm.payTelBill1();
	}	
}
class ABCATM01{//农行ATM
	private UnionPay1 card;//一张银联卡
	public void insertCard(UnionPay1 card){//插入银联卡方法
		this.card = card;
	}
	public void payTelBill1(){//缴话费功能按钮
		if(card instanceof ABC1){
			ABC1 abcCard = (ABC1)card;//如果是农行卡，则强制转换类型为农行卡类型的引用，使其能够具有缴话费功能
			abcCard.payTelBill("12341234123", 200);
			System.out.println("缴话费成功");
		}else{
			System.out.println("这不是农行卡");
		}
	}
}
interface UnionPay1{//银联卡接口
	public abstract double getbalance();//查询余额功能
	public abstract boolean checkpwd(String input);//检验密码功能
	public abstract boolean drawMoney(double number);//取款功能 
}
interface ICBC1 extends UnionPay1{//工行卡接口
	abstract boolean payOnline(double number);//在线充值功能	
}
interface ABC1 extends UnionPay1{//农行卡接口
	abstract boolean payTelBill(String phoneNum, double number);//缴话费功能
}
class ICBCImpl1 implements ICBC1{//工行卡类
	double money;//账户金额
	String pwd;//用户密码
	ICBCImpl1(double money, String pwd){//构造函数
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean checkpwd(String input) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean drawMoney(double number) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double getbalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean payOnline(double number) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
class ABCImpl1 implements ABC1{//农行卡类
	double money;//账户金额
	String pwd;//用户密码
	ABCImpl1(double money, String pwd){//构造方法
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(String phoneNum, double number) {//重写缴话费功能
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkpwd(String input) {//重写检查密码功能
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//重写取款功能
		
		return false;
	}
	@Override
	public double getbalance() {//重写查询余额功能
		return money;
	}
	
}
