package a02.day06;
//ABCAtm练习，向上造型，强制转换造型，引用调用方法
public class UnionPayAtmTest {
	public static void main(String[] args) {
		ABCATM abcATM = new ABCATM();
		UnionPay card = new ABCImpl(2000,"123");
		abcATM.payTelBill();//没有插入银联卡
		abcATM.insertCard(card);
		abcATM.payTelBill();
	}
}
class ABCATM {//农行ATM机类
	private UnionPay card;//一张银联卡
	public void insertCard(UnionPay card){//插入银联卡
		this.card = card;
	}
	public void payTelBill(){//ATM机上的缴话费功能按键
		if(card instanceof ABC){
			ABC abcCard = (ABC)card;//强制类型转换
			abcCard.payTelBill("12345612345", 200);
			System.out.println("缴话费成功！");
		}else{
			System.out.println("这不是农行卡，不能缴话费！");
		}
	}
}
interface UnionPay{//银联卡接口
	public abstract double getBalance();//查询金额功能
	public abstract boolean checkPwd(String pwd);//检验密码功能
	public abstract boolean drawMoney(double number);//取款功能
}
interface ABC extends UnionPay{//农行卡接口
	public abstract boolean payTelBill(String phoneNum, double number);//缴话费功能
}
class ABCImpl implements ABC{
	private double money;//账户金额
	private String pwd;//用户密码
	ABCImpl(double money, String pwd){
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(String phoneNum, double number) {//重写缴话费功能方法
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkPwd(String pwd) {//重写检验密码功能
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//重写取款功能方法
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double getBalance() {//重写查询余额方法
		
		return money;
	}
	
}