package a02;

import java.util.Scanner;

//农行ATM程序练习
public class testABCATM {
	public static void main(String[] args) {
		ABCATM atm = new ABCATM();
		ABCImpl abc = new ABCImpl(3000,"123123");
		atm.insertCard(abc);//必须先插入卡片，才能在ABCATM类中初始化UnionPay card。
//		abc.checkPwd("123123");//密码正确
		atm.showBalance();
		atm.allMenu();
	}
}
class ABCATM{//农行ATM机类
	private UnionPay card;//一张银联卡
	public void insertCard(UnionPay userCard){//农行ATM机插入银行卡功能，此处参数不能和成员变量名称相同？？？
		if(card == null){
			card = userCard;
		}
	}
	public void outCard(){//农行ATM机吐出卡片
		if(card != null){
			this.card = null;
		}
	}
	public void showBalance(){//农行ATM机查询余额功能
		System.out.println("当前余额为："+ card.getBalance());
	}
	public void takeMoney(){//农行ATM机取款功能
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入取款金额（0.00￥）：");
		double number = Double.parseDouble(scan.next());
		if(card.drawMoney(number)){
			System.out.println("取款成功！");
		}else{
			System.out.println("取款失败！");
		}
		scan.close();
	}
	public void payTelBill(){//农行ATM机缴话费功能
		if(card instanceof ABC){
			ABC abcCard = (ABC)card;
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入11位的手机号码：");
			String phoneNum = scan.next();
			System.out.println("请输入缴话费金额（0.00￥）：");
			double number = Double.parseDouble(scan.next());
			if(abcCard.payTelBill(number, phoneNum)){
				System.out.println("缴话费成功！");
			}else{
				System.out.println("余额不足！");
			}
			scan.close();
		}else{
			System.out.println("这不是农行卡，无法完成缴费，请使用农行卡缴话费！");
		}
	}
	public void allMenu(){//农行ATM菜单功能
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入密码：");
		String input = scan.next();
//		System.out.println(input);
		if(card.checkPwd(input)){
			System.out.println("密码正确！");
//			System.out.println("请选择功能：");
//			System.out.println("1.查询余额	2.取款	3.缴话费");
			System.out.println("请选择功能：\n 1.查询余额  2.取款  3.缴话费");
			int num = scan.nextInt();
			switch(num){
			case 1:
				showBalance();
				break;
			case 2:
				takeMoney();
				break;
			case 3:
				payTelBill();
				break;
			default:
				System.out.println("输入有误！请重新输入");	
			}
		}else{
			System.out.println("密码有误！");
		}
		this.outCard();
	}
}
interface UnionPay{//银联卡接口
	public abstract boolean checkPwd(String input);//检验密码功能
	public abstract double getBalance();//查询余额功能
	public abstract boolean drawMoney(double number);//取款功能
}
interface ABC extends UnionPay{//农行卡接口
	public abstract boolean payTelBill(double number, String phoneNum);//缴话费功能
}
interface ICBC extends UnionPay{//工行卡接口
	public abstract boolean payOnline(double number);//在线支付功能
}
class ABCImpl implements ABC{//农行卡类
	private double money;//账户金额
	private String pwd;//用户密码
	public ABCImpl(double money, String pwd){//构造方法
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(double number, String phoneNum) {//重写缴话费功能
		if(phoneNum.length() == 11 && money + 2000 - number >= 0){
			money -= number;
			System.out.println("缴话费"+ number +"元成功，账户余额："+ money + "元");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//重写检验密码功能
		if(pwd.equals(input)){
			System.out.println("密码正确！");
			return true;
		}else{
			System.out.println("密码错误！");
			return false;
		}
	}
	@Override
	public boolean drawMoney(double number) {//重写取款功能
		if(money + 2000 - number >= 0){
			System.out.println("取款成功！");
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//重写查询余额功能
		return money;
	}	
}
class ICBCImpl implements ICBC{//工行卡类
	private double money;//账户金额
	private String pwd;//用户密码
	public ICBCImpl(double money, String pwd){//构造方法
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payOnline(double number) {//重写在线支付功能
		if(number <= money){
			System.out.println("在线支付成功！");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//重写检验密码功能
		if(pwd.equals(input)){
			System.out.println("密码正确");
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//重写取款功能
		if(number <= money){
			System.out.println("取款成功！");
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//重写查询余额功能
		return money;
	}	
}