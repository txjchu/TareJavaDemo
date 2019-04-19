package oo.day06;
//���п�ϵͳ
public class UnionPayTest {
	public static void main(String[] args) {
		
		ABCATM atm=new ABCATM();
		UnionPay card=new ABCImpl();//������--ũ�п�
		atm.insertCard(card);//�忨
		atm.payTelBill();
	}
}
/*
 * ũ�е�ATM��ϵͳ��
 * 1.ʲô���п����ܲ�
 * 2.ֻ��ũ�п�����֧���绰��
 * 
 */


class ABCATM{//ũ��ATM��
	private UnionPay card;//������
	public void insertCard(UnionPay card){//����������
		this.card=card;
	} 
	public void payTelBill(){//֧���绰�Ѱ�ť
		if(card instanceof ABC){//��ũ�п�
			ABC abcCard=(ABC)card;//ǿ��ת��Ϊũ�п�
			abcCard.payTelBill("12345678912", 200);
		}else{
			System.out.println("����ũ�п�������֧������");
		}
	}
	}



interface UnionPay{//�����ӿ�
	public double getBalance();//��ѯ���
	public boolean drawMoney(double number);//ȡǮ
	public boolean checkPwd(String input);//��֤����
}

interface ABC extends UnionPay{//ũҵ�ӿ�
	public boolean payTelBill(String phoneNum,double sum);//֧���绰��		
}

class ABCImpl implements ABC{
	
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public boolean payTelBill(String phoneNum,double num){
		System.out.println("֧���绰�ѳɹ�");//--------------------
		return true;
}
}

interface ICBC extends UnionPay{//���нӿ�
	public void payOline(double number);//����֧��
}
	
class ICBCImpl implements ICBC{
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public void payOline(double number){} 
}




