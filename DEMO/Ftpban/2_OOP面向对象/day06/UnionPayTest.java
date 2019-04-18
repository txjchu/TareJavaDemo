package oo.day06;
//���п�ϵͳ
public class UnionPayTest {
	public static void main(String[] args) {
		ABCATM atm = new ABCATM(); //����atm����
		UnionPay card = new ABCImpl(); //������(ũ�п�)
		atm.insertCard(card); //�忨
		atm.payTelBill(); //֧���绰��
	}
}
class ABCATM{ //ũ��ATM��
	private UnionPay card; //������
	public void insertCard(UnionPay card){ //�忨
		this.card = card;
	}
	public void payTelBill(){ //֧���绰��(��ť)
		if(card instanceof ABC){ //��ũ�п�
			ABC abcCard = (ABC)card; //ǿתΪũ�п�
			abcCard.payTelBill("12345678945", 200); //֧���绰��
		}else{
			System.out.println("����ũ�п�������֧���绰��");
		}
	}
}







interface UnionPay{ //�����ӿ�
	public double getBalance(); //��ѯ���
	public boolean drawMoney(double number); //ȡǮ
	public boolean checkPwd(String input); //��������Ƿ���ȷ
}
interface ABC extends UnionPay{ //ũ�нӿ�
	public boolean payTelBill(String phoneNum,double sum); //֧���绰��
}
class ABCImpl implements ABC{ //ũ�п�
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public boolean payTelBill(String phoneNum,double sum){
		System.out.println("֧���绰�ѳɹ�");
		return true;
	}
}









interface ICBC extends UnionPay{ //���нӿ�
	public void payOnline(double number); //����֧��
}
class ICBCImpl implements ICBC{ //���п�
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public void payOnline(double number){}
}











