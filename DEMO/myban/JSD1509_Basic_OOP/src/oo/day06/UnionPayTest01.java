package oo.day06;

public class UnionPayTest01 {
	public static void main(String[] args) {
		ABCATM01 atm = new ABCATM01();
		UnionPay1 card = new ABCImpl1(2000,"123");
		atm.insertCard(card);
		atm.payTelBill1();
	}	
}
class ABCATM01{//ũ��ATM
	private UnionPay1 card;//һ��������
	public void insertCard(UnionPay1 card){//��������������
		this.card = card;
	}
	public void payTelBill1(){//�ɻ��ѹ��ܰ�ť
		if(card instanceof ABC1){
			ABC1 abcCard = (ABC1)card;//�����ũ�п�����ǿ��ת������Ϊũ�п����͵����ã�ʹ���ܹ����нɻ��ѹ���
			abcCard.payTelBill("12341234123", 200);
			System.out.println("�ɻ��ѳɹ�");
		}else{
			System.out.println("�ⲻ��ũ�п�");
		}
	}
}
interface UnionPay1{//�������ӿ�
	public abstract double getbalance();//��ѯ����
	public abstract boolean checkpwd(String input);//�������빦��
	public abstract boolean drawMoney(double number);//ȡ��� 
}
interface ICBC1 extends UnionPay1{//���п��ӿ�
	abstract boolean payOnline(double number);//���߳�ֵ����	
}
interface ABC1 extends UnionPay1{//ũ�п��ӿ�
	abstract boolean payTelBill(String phoneNum, double number);//�ɻ��ѹ���
}
class ICBCImpl1 implements ICBC1{//���п���
	double money;//�˻����
	String pwd;//�û�����
	ICBCImpl1(double money, String pwd){//���캯��
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
class ABCImpl1 implements ABC1{//ũ�п���
	double money;//�˻����
	String pwd;//�û�����
	ABCImpl1(double money, String pwd){//���췽��
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(String phoneNum, double number) {//��д�ɻ��ѹ���
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkpwd(String input) {//��д������빦��
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ���
		
		return false;
	}
	@Override
	public double getbalance() {//��д��ѯ����
		return money;
	}
	
}
