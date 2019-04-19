package a02.day05;
//银联卡接口练习
public class UnionPayTest01 {
	public static void main(String[] args) {
		UnionPay01 abc1 = new ABCImpl01(3500, "123");
		System.out.println(abc1.getBalance());
		System.out.println(abc1.checkPwd("121"));
		System.out.println(abc1.drawMoney(3000));
		System.out.println(abc1.getBalance());//余额：500
		System.out.println(abc1.drawMoney(2000));//取款2000后，透支1500
		ABC01 abc2 = new ABCImpl01(4000,"111");
		System.out.println(abc2.payTelBill("12341234123", 4500));
		UnionPay01 ccb1 = new CCBImpl(4500,"222");
		System.out.println(ccb1.getBalance());
		System.out.println(ccb1.checkPwd("222"));
		System.out.println(ccb1.drawMoney(2000));
		CCB ccb2 = new CCBImpl(3000,"333");
		ccb2.payGusBill(1000);
	}
}
interface UnionPay01{//银联卡接口
	abstract double getBalance();//查询余额功能
	abstract boolean drawMoney(double number);//取款功能
	abstract boolean checkPwd(String input);//验证密码功能
}
interface ICBC01 extends UnionPay01{//工行卡接口，继承银联卡接口
	abstract boolean payOnline(double number);//在线充值功能	
}
interface ABC01 extends UnionPay01{//农行卡接口，继承银联卡接口
	abstract boolean payTelBill(String phoneNum, double number);//交话费功能
}
interface CCB extends UnionPay01{//建行卡接口，继承银联卡接口
	abstract void payGusBill(double number);//缴燃气费功能
}
class CCBImpl implements CCB{
	private double money;//账户余额
	private String pwd;//密码
	public CCBImpl(double money,String pwd){//构造方法
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public void payGusBill(double number) {//重写缴燃气费功能
		if(number <= money){
			money -= number;
			System.out.println("缴燃气费成功！");
		}else{
			System.out.println("余额不足！");
		}
	}
	@Override
	public boolean checkPwd(String input) {//重写验证密码功能
		if(pwd.equals(input)){
			System.out.println("密码正确！");
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//重写取款功能
		if(number <= money){
			money -= number;
			System.out.println("取款成功！");
		}
		return false;
	}
	@Override
	public double getBalance() {//重写查询余额功能
		return money;
	}
	
}
class ICBCImpl01 implements ICBC01{//工行卡类，实现工行卡接口
	private double money;//账户金额
	private String pwd;//密码
	public ICBCImpl01(double money, String pwd){//构造方法
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean checkPwd(String input) {//重写密码验证方法
		if(pwd.equals(input)){
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//重写取款方法
		if(number <= money){
			money -= number;
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//重写查询余额方法		
		return money;
	}
	@Override
	public boolean payOnline(double number) {//重写在线充值功能方法
		if(number <= money){
			money -= number;
			System.out.println("充值成功!");
			return true;
		}
		return false;
	}
}
class ABCImpl01 implements ABC01{//农行卡类，实现农行卡接口
	private double money;//账户金额
	private String pwd;//用户密码
	public ABCImpl01(double money, String pwd){//构造方法
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(String phoneNum, double sum) {//重写交话费功能方法
		if(phoneNum.length() == 11 && money + 2000 - sum >= 0){
			money -= sum;
			System.out.println("缴费成功！");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//重写验证密码方法
		if(pwd.equals(input)){
			System.out.println("密码正确！");
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//重写取款方法
		if(money +2000 - number >= 0){
			money -= number;
			System.out.println("取款成功");
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//重写查询余额方法
		return money;
	}
	
}