package a02;

import java.util.Scanner;

//ũ��ATM������ϰ
public class testABCATM {
	public static void main(String[] args) {
		ABCATM atm = new ABCATM();
		ABCImpl abc = new ABCImpl(3000,"123123");
		atm.insertCard(abc);//�����Ȳ��뿨Ƭ��������ABCATM���г�ʼ��UnionPay card��
//		abc.checkPwd("123123");//������ȷ
		atm.showBalance();
		atm.allMenu();
	}
}
class ABCATM{//ũ��ATM����
	private UnionPay card;//һ��������
	public void insertCard(UnionPay userCard){//ũ��ATM���������п����ܣ��˴��������ܺͳ�Ա����������ͬ������
		if(card == null){
			card = userCard;
		}
	}
	public void outCard(){//ũ��ATM���³���Ƭ
		if(card != null){
			this.card = null;
		}
	}
	public void showBalance(){//ũ��ATM����ѯ����
		System.out.println("��ǰ���Ϊ��"+ card.getBalance());
	}
	public void takeMoney(){//ũ��ATM��ȡ���
		Scanner scan = new Scanner(System.in);
		System.out.println("������ȡ���0.00������");
		double number = Double.parseDouble(scan.next());
		if(card.drawMoney(number)){
			System.out.println("ȡ��ɹ���");
		}else{
			System.out.println("ȡ��ʧ�ܣ�");
		}
		scan.close();
	}
	public void payTelBill(){//ũ��ATM���ɻ��ѹ���
		if(card instanceof ABC){
			ABC abcCard = (ABC)card;
			Scanner scan = new Scanner(System.in);
			System.out.println("������11λ���ֻ����룺");
			String phoneNum = scan.next();
			System.out.println("������ɻ��ѽ�0.00������");
			double number = Double.parseDouble(scan.next());
			if(abcCard.payTelBill(number, phoneNum)){
				System.out.println("�ɻ��ѳɹ���");
			}else{
				System.out.println("���㣡");
			}
			scan.close();
		}else{
			System.out.println("�ⲻ��ũ�п����޷���ɽɷѣ���ʹ��ũ�п��ɻ��ѣ�");
		}
	}
	public void allMenu(){//ũ��ATM�˵�����
		Scanner scan = new Scanner(System.in);
		System.out.println("���������룺");
		String input = scan.next();
//		System.out.println(input);
		if(card.checkPwd(input)){
			System.out.println("������ȷ��");
//			System.out.println("��ѡ���ܣ�");
//			System.out.println("1.��ѯ���	2.ȡ��	3.�ɻ���");
			System.out.println("��ѡ���ܣ�\n 1.��ѯ���  2.ȡ��  3.�ɻ���");
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
				System.out.println("������������������");	
			}
		}else{
			System.out.println("��������");
		}
		this.outCard();
	}
}
interface UnionPay{//�������ӿ�
	public abstract boolean checkPwd(String input);//�������빦��
	public abstract double getBalance();//��ѯ����
	public abstract boolean drawMoney(double number);//ȡ���
}
interface ABC extends UnionPay{//ũ�п��ӿ�
	public abstract boolean payTelBill(double number, String phoneNum);//�ɻ��ѹ���
}
interface ICBC extends UnionPay{//���п��ӿ�
	public abstract boolean payOnline(double number);//����֧������
}
class ABCImpl implements ABC{//ũ�п���
	private double money;//�˻����
	private String pwd;//�û�����
	public ABCImpl(double money, String pwd){//���췽��
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(double number, String phoneNum) {//��д�ɻ��ѹ���
		if(phoneNum.length() == 11 && money + 2000 - number >= 0){
			money -= number;
			System.out.println("�ɻ���"+ number +"Ԫ�ɹ����˻���"+ money + "Ԫ");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//��д�������빦��
		if(pwd.equals(input)){
			System.out.println("������ȷ��");
			return true;
		}else{
			System.out.println("�������");
			return false;
		}
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ���
		if(money + 2000 - number >= 0){
			System.out.println("ȡ��ɹ���");
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//��д��ѯ����
		return money;
	}	
}
class ICBCImpl implements ICBC{//���п���
	private double money;//�˻����
	private String pwd;//�û�����
	public ICBCImpl(double money, String pwd){//���췽��
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payOnline(double number) {//��д����֧������
		if(number <= money){
			System.out.println("����֧���ɹ���");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//��д�������빦��
		if(pwd.equals(input)){
			System.out.println("������ȷ");
			return true;
		}
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ���
		if(number <= money){
			System.out.println("ȡ��ɹ���");
			return true;
		}
		return false;
	}
	@Override
	public double getBalance() {//��д��ѯ����
		return money;
	}	
}