package mycase;
/**
 * �����ձ��ӣ�1��11����1��7�����ó���д����εõ�2��ˮ
 * @author Administrator
 *
 */
public class WaterGame {
	public static void main(String[] args) {
		int B = 0;//�󱭳�ʼֵ		
		int S = 0;//С����ʼֵ
		int b = 0;//һ�λ���ʣ�����ˮ
		int s = 0;//һ�λ��С��ʣ�����ˮ
		int a = 11 - B;//ÿ�λ�У�С������е�������ˮ
		int count = 0;//�������
		for(int i = 0; i < 100; i ++){
			if(b == 11){//������ʣ��ˮ����11��ʱ������
				B = 0;
			} else {	
				B = b;
			}
			
			if(s == 0){//��С���е�ʣ��ˮ����0��ʱ����װ��7��ˮ
				S = 7;
			} else {	
				S = s;  	
			}
			
			a = 11 - B;//���л���װ����ˮ
			if(a >= S){//��С���е�ˮ����a����a = С�������е�ˮ
				a = S; 	
			}
			
			b = B + a;
			s = S - a;
			
			count ++;
			if(s == 2){
				break;
			}
		}
		System.out.println("��"+ count +"��ʱ��S���е�ˮ��"+ s +"��.");
	}
}
