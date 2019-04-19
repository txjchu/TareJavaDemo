package a02.day05;

import java.util.Scanner;

//���п��ӿ���ϰ
public class UnionPayTest {
	public static void main(String[] args) {
		UnionPay icbc = new ICBCImpl(20000.01122,"123456");
//		System.out.println(icbc.getBalance());//20000.01122
//		System.out.println(icbc.checkPwd("1234"));//false
//		System.out.println(icbc.drawMoney(3000));//true
////		icbc.payOnline();//�������
		ICBC icbc1 = new ICBCImpl(1000,"111");
//		System.out.println(icbc1.getBalance());
//		icbc1.payOnline(200);//ICBC�ӿ����͵����ÿ��Ե���ICBC�ӿڶ���ĳ��󷽷�
//		System.out.println(icbc1.getBalance());
		ABC abc = new ABCImpl(2100,"123");
//		System.out.println(abc.getBalance());
//		System.out.println(abc.checkPwd("123"));
//		System.out.println(abc.payTelBill("12312312312", 1000));
//		System.out.println(abc.drawMoney(3200));
//		System.out.println(abc.getBalance());
		Scanner scan = new Scanner(System.in);
		System.out.println("���������룡���룺0--�˳�");
		while(true){
			String input = scan.next();
			if("0".equals(input)){
				System.out.println("�ټ���");
				break;
			}
			if(icbc.checkPwd(input)){
				System.out.println("������ȷ���������");
				double number = Double.parseDouble(scan.next());//���ַ���ת��ΪDouble��
				if(icbc.drawMoney(number)){
					System.out.println("ȡ��ɹ�����"+ icbc.getBalance());
					break;
				}else{
					System.out.println("ȡ��ʧ��!��������������룺0--�˳�");
				}
			}else{
				System.out.println("��������������������룬���룺0--�˳�");
			}
		}
		scan.close();
	}
}
interface UnionPay{//�������ӿڣ�1.��ѯ��2.ȡ�3.�������
	abstract double getBalance();//��ѯ���
	abstract boolean drawMoney(double number);//ȡ��
	abstract boolean checkPwd(String input);//�������
}
interface ICBC extends UnionPay{//���п��ӿڣ��̳��������ӿ�
	public void payOnline(double number);//���п�������֧������
}
interface ABC extends UnionPay{//ũ�п��ӿڣ��̳��������ӿ�
	public boolean payTelBill(String phoneNum, double sum);//ũ�п��н����ѹ���
}
class ICBCImpl implements ICBC{//���Ῠ��ʵ���࣬�̳й��п��ӿ�
	private double money;//�����洢���
	private String pwd;//���������û����������
	public ICBCImpl(double money, String pwd){//���췽��
		this.money = money;
		this.pwd = pwd;
	}
	public double getBalance(){//��д��ѯ���ķ���		
		return money; 
	}
	public boolean drawMoney(double number){//��дȡ��ķ���
		if(number <= money){//���ȡ���������������
			money -= number;
			return true;
		}
		return false;
	}
	public boolean checkPwd(String input){//��д�������ķ���
		if(pwd.equals(input)){//����û�����������ԭ����һ�¡�input.equals(pwd)�к�����?��
			return true;
		}else{
			return false;			
		}
	}
	public void payOnline(double number){//��д����֧���ķ���
		if(number <= money){
			money -= number;
		}
	}
}
class ABCImpl implements ABC{//ũ�п�ʵ����
	private double balance;//ũ�п�������͸֧2000
	private String password;//ũ�п�����
	public ABCImpl(double balance, String password){//���췽��
		this.balance = balance;
		this.password = password;
	}
	@Override
	public boolean payTelBill(String phoneNum, double sum) {//��д�����ѹ��ܷ���
		if((balance - sum) + 2000 >= 0 && phoneNum.length() == 11){//����͸֧2000(�����Ҫ��ʵ�ʵĶ�2000)
			balance -= sum;
			System.out.println("�ɷѳɹ���");
			return true;
		}
		return false;
	}
	@Override
	public boolean checkPwd(String input) {//��д������뷽��
		if(password.equals(input)){
			System.out.println("������ȷ��");
			return true;
		}else{
			System.out.println("�������");
			return false;
		}
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ��ܵķ���
		if(balance - number + 2000 >= 0){//����͸֧2000
			balance -= number;
			return true;
		}		
		return false;
	}
	@Override
	public double getBalance() {//��д��ѯ����
		// TODO Auto-generated method stub
		return balance;
	}
	
}
