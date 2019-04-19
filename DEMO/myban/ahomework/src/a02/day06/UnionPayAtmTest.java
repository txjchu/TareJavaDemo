package a02.day06;
//ABCAtm��ϰ���������ͣ�ǿ��ת�����ͣ����õ��÷���
public class UnionPayAtmTest {
	public static void main(String[] args) {
		ABCATM abcATM = new ABCATM();
		UnionPay card = new ABCImpl(2000,"123");
		abcATM.payTelBill();//û�в���������
		abcATM.insertCard(card);
		abcATM.payTelBill();
	}
}
class ABCATM {//ũ��ATM����
	private UnionPay card;//һ��������
	public void insertCard(UnionPay card){//����������
		this.card = card;
	}
	public void payTelBill(){//ATM���ϵĽɻ��ѹ��ܰ���
		if(card instanceof ABC){
			ABC abcCard = (ABC)card;//ǿ������ת��
			abcCard.payTelBill("12345612345", 200);
			System.out.println("�ɻ��ѳɹ���");
		}else{
			System.out.println("�ⲻ��ũ�п������ܽɻ��ѣ�");
		}
	}
}
interface UnionPay{//�������ӿ�
	public abstract double getBalance();//��ѯ����
	public abstract boolean checkPwd(String pwd);//�������빦��
	public abstract boolean drawMoney(double number);//ȡ���
}
interface ABC extends UnionPay{//ũ�п��ӿ�
	public abstract boolean payTelBill(String phoneNum, double number);//�ɻ��ѹ���
}
class ABCImpl implements ABC{
	private double money;//�˻����
	private String pwd;//�û�����
	ABCImpl(double money, String pwd){
		this.money = money;
		this.pwd = pwd;
	}
	@Override
	public boolean payTelBill(String phoneNum, double number) {//��д�ɻ��ѹ��ܷ���
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkPwd(String pwd) {//��д�������빦��
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean drawMoney(double number) {//��дȡ��ܷ���
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double getBalance() {//��д��ѯ����
		
		return money;
	}
	
}