package a01;
//����Ƽ�ϵͳ V1 V2 V3
import java.util.Scanner;

public class shopping {
	public static void main(String[] args) {
//		Scanner console = new Scanner(System.in);
//		System.out.println("��������Ʒ���ۣ�������");
//		double unitPrice = console.nextDouble();
//		System.out.println("��������Ʒ������");
//		double amount = console.nextDouble();
//		System.out.println("�������������");
//		double money = console.nextDouble();
//		console.close();
//		//������Ʒ�ܼۣ������������
//		double amountPrice = unitPrice * amount;
//		if(money >= amountPrice){
//			double remoney = money - amountPrice;		
//			System.out.println("֧����������"+amountPrice+",���㣨������"+remoney);
//		}else{
//			double haicha = amountPrice - money; 
//			System.out.println("���㣬���������"+haicha);
//		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("��������Ʒ���ۣ�������");
		double da1 = scan.nextDouble();
		System.out.println("��������Ʒ������������");
		double sa2 = scan.nextDouble();
		System.out.println("������������������");
		double sa3 = scan.nextDouble();
		scan.close();
		//�����Ƿ��������Դ���500�Ľ����ۿ۴���
		double za4 = da1 * sa2;
		if( 0 <= sa3 && sa3 < za4){
			//��Ӧ�ս�����������ʱ����ʾ������������
			System.out.println("��������ȷ������");
			System.out.println("Ӧ�ս�������" + za4 +";�벹��������" + (za4 - sa3) );
		}else if(za4 <= sa3 && sa3 <500){
			System.out.println("Ӧ�ս�������" + za4 + ";Ӧ���㣨������" + (sa3 - za4));
		}else if(500 <= sa3){
			System.out.println("Ӧ�ս�������" + za4 + ";Ӧ���㣨������" + (sa3 - za4 * 0.8));
		}
		
	}
}