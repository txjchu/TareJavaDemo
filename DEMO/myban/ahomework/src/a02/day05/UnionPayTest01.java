package a02.day05;
//�������ӿ���ϰ
public class UnionPayTest01 {
	public static void main(String[] args) {
		UnionPay01 abc1 = new ABCImpl01(3500, "123");
		System.out.println(abc1.getBalance());
		System.out.println(abc1.checkPwd("121"));
		System.out.println(abc1.drawMoney(3000));
		System.out.println(abc1.getBalance());//��500
		System.out.println(abc1.drawMoney(2000));//ȡ��2000��͸֧1500
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
interface UnionPay01{//�������ӿ�
	abstract double getBalance();//��ѯ����
	abstract boolean drawMoney(double number);//ȡ���
	abstract boolean checkPwd(String input);//��֤���빦��
}
interface ICBC01 extends UnionPay01{//���п��ӿڣ��̳��������ӿ�
	abstract boolean payOnline(double number);//���߳�ֵ����	
}
interface ABC01 extends UnionPay01{//ũ�п��ӿڣ��̳��������ӿ�
	abstract boolean payTelBill(String phoneNum, double number);//�����ѹ���
}
interface CCB extends UnionPay01{//���п��ӿڣ��̳��������ӿ�
	abstract void payGusBill(double number);//��ȼ���ѹ���
}
class CCBImpl implements CCB{
	private double money;//�˻����
	private String pwd;//����
	public CCBImpl(double money,String pwd){//���췽��
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public void payGusBill(double number) {//��д��ȼ���ѹ���
		if(number <= money){
			money -= number;
			System.out.println("��ȼ���ѳɹ���");
		}else{
			System.out.println("���㣡");
		}
	}
	@Override
	public boolean checkPwd(String input) {//��д��֤���빦��
		if(pwd.equals(input)){
			System.out.println("������ȷ��");
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ���
		if(number <= money){
			money -= number;
			System.out.println("ȡ��ɹ���");
		}
		return false;
	}
	@Override
	public double getBalance() {//��д��ѯ����
		return money;
	}
	
}
class ICBCImpl01 implements ICBC01{//���п��࣬ʵ�ֹ��п��ӿ�
	private double money;//�˻����
	private String pwd;//����
	public ICBCImpl01(double money, String pwd){//���췽��
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean checkPwd(String input) {//��д������֤����
		if(pwd.equals(input)){
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ���
		if(number <= money){
			money -= number;
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//��д��ѯ����		
		return money;
	}
	@Override
	public boolean payOnline(double number) {//��д���߳�ֵ���ܷ���
		if(number <= money){
			money -= number;
			System.out.println("��ֵ�ɹ�!");
			return true;
		}
		return false;
	}
}
class ABCImpl01 implements ABC01{//ũ�п��࣬ʵ��ũ�п��ӿ�
	private double money;//�˻����
	private String pwd;//�û�����
	public ABCImpl01(double money, String pwd){//���췽��
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(String phoneNum, double sum) {//��д�����ѹ��ܷ���
		if(phoneNum.length() == 11 && money + 2000 - sum >= 0){
			money -= sum;
			System.out.println("�ɷѳɹ���");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//��д��֤���뷽��
		if(pwd.equals(input)){
			System.out.println("������ȷ��");
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ���
		if(money +2000 - number >= 0){
			money -= number;
			System.out.println("ȡ��ɹ�");
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//��д��ѯ����
		return money;
	}
	
}