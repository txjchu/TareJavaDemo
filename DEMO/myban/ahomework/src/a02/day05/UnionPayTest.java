package a02.day05;

import java.util.Scanner;

//银行卡接口练习
public class UnionPayTest {
	public static void main(String[] args) {
		UnionPay icbc = new ICBCImpl(20000.01122,"123456");
//		System.out.println(icbc.getBalance());//20000.01122
//		System.out.println(icbc.checkPwd("1234"));//false
//		System.out.println(icbc.drawMoney(3000));//true
////		icbc.payOnline();//编译错误，
		ICBC icbc1 = new ICBCImpl(1000,"111");
//		System.out.println(icbc1.getBalance());
//		icbc1.payOnline(200);//ICBC接口类型的引用可以调用ICBC接口定义的抽象方法
//		System.out.println(icbc1.getBalance());
		ABC abc = new ABCImpl(2100,"123");
//		System.out.println(abc.getBalance());
//		System.out.println(abc.checkPwd("123"));
//		System.out.println(abc.payTelBill("12312312312", 1000));
//		System.out.println(abc.drawMoney(3200));
//		System.out.println(abc.getBalance());
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入密码！输入：0--退出");
		while(true){
			String input = scan.next();
			if("0".equals(input)){
				System.out.println("再见！");
				break;
			}
			if(icbc.checkPwd(input)){
				System.out.println("密码正确！请输入金额：");
				double number = Double.parseDouble(scan.next());//将字符串转换为Double型
				if(icbc.drawMoney(number)){
					System.out.println("取款成功！余额："+ icbc.getBalance());
					break;
				}else{
					System.out.println("取款失败!请重新输入金额，输入：0--退出");
				}
			}else{
				System.out.println("密码错误！请重新输入密码，输入：0--退出");
			}
		}
		scan.close();
	}
}
interface UnionPay{//银联卡接口，1.查询余额，2.取款，3.检查密码
	abstract double getBalance();//查询余额
	abstract boolean drawMoney(double number);//取款
	abstract boolean checkPwd(String input);//检查密码
}
interface ICBC extends UnionPay{//工行卡接口，继承银联卡接口
	public void payOnline(double number);//工行卡有在线支付功能
}
interface ABC extends UnionPay{//农行卡接口，继承银联卡接口
	public boolean payTelBill(String phoneNum, double sum);//农行卡有交话费功能
}
class ICBCImpl implements ICBC{//工会卡的实现类，继承工行卡接口
	private double money;//用来存储余额
	private String pwd;//用来储存用户输入的密码
	public ICBCImpl(double money, String pwd){//构造方法
		this.money = money;
		this.pwd = pwd;
	}
	public double getBalance(){//重写查询余额的方法		
		return money; 
	}
	public boolean drawMoney(double number){//重写取款的方法
		if(number <= money){//如果取款数不大于余额数
			money -= number;
			return true;
		}
		return false;
	}
	public boolean checkPwd(String input){//重写检查密码的方法
		if(pwd.equals(input)){//如果用户输入的密码和原密码一致【input.equals(pwd)有何区别?】
			return true;
		}else{
			return false;			
		}
	}
	public void payOnline(double number){//重写在线支付的方法
		if(number <= money){
			money -= number;
		}
	}
}
class ABCImpl implements ABC{//农行卡实现类
	private double balance;//农行卡余额，允许透支2000
	private String password;//农行卡密码
	public ABCImpl(double balance, String password){//构造方法
		this.balance = balance;
		this.password = password;
	}
	@Override
	public boolean payTelBill(String phoneNum, double sum) {//重写交话费功能方法
		if((balance - sum) + 2000 >= 0 && phoneNum.length() == 11){//允许透支2000(即余额要比实际的多2000)
			balance -= sum;
			System.out.println("缴费成功！");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//重写检查密码方法
		if(password.equals(input)){
			System.out.println("密码正确！");
			return true;
		}else{
			System.out.println("密码错误！");
			return false;
		}
	}
	@Override
	public boolean drawMoney(double number) {//重写取款功能的方法
		if(balance - number + 2000 >= 0){//允许透支2000
			balance -= number;
			return true;
		}		
		return false;
	}
	@Override
	public double getBalance() {//重写查询余额方法
		// TODO Auto-generated method stub
		return balance;
	}
	
}
