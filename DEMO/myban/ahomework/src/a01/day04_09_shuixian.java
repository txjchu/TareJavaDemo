package a01;
//����һ����Χ�ڵ������Ƿ�Ϊˮ�ɻ���
/* 1.��һ�����ֲַ�ɼ�����������
 * 2.�ж��Ƿ�Ϊˮ�ɻ���sum == 1*1*1+2*2*2+3*3*3?
 * 3.�ж�һ����Χ����Щ����Ϊˮ�ɻ���
 */
public class day04_09_shuixian {
	public static void main(String[] args) {
		for(int i = 1; i <= 10000; i++){//3.�趨��Χ			
			int num = i;			
			int sum = 0;
			while(true){//1.��ֶ�λ��
				int d = num % 10;
				sum = sum + d*d*d;
							//��ѭ���Ƶ����̣�ѭ������������Ϊnum=0.	
				if(num == 0){//====������d==0,��Ϊ407��370�������е���λ��Ϊ0
					break;
				}
				num /= 10;
//			System.out.println("d:" + d);
//			System.out.println(sum);
			}
//			System.out.println(sum);
			if(sum == i){//2.�ж��Ƿ�Ϊˮ�ɻ���
				System.out.println(i +"��ˮ�ɻ���");
			}
		}
	}
}
