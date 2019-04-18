package oo.day05;
//���п�ϵͳ
public class UnionPayTest {
	public static void main(String[] args) {
		ABCImpl  card1 = new ABCImpl(); //ũ�п�
		ABC      card2 = new ABCImpl(); //ũ�п�---------��������
		UnionPay card3 = new ABCImpl(); //������(ũ�п�)--��������
	}
}

interface UnionPay{ //�����ӿ�
	public double getBalance(); //��ѯ���
	public boolean drawMoney(double number); //ȡǮ
	public boolean checkPwd(String input); //��������Ƿ���ȷ
}
interface ICBC extends UnionPay{ //���нӿ�
	public void payOnline(double number); //����֧��
}
interface ABC extends UnionPay{ //ũ�нӿ�
	public boolean payTelBill(String phoneNum,double sum); //֧���绰��
}
class ICBCImpl implements ICBC{ //���п�
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public void payOnline(double number){}
}
class ABCImpl implements ABC{ //ũ�п�
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public boolean payTelBill(String phoneNum,double sum){return true;}
}










