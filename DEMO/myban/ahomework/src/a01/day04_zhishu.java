package a01;
/**
 * ����һ����Χ�ڵ���������
 * ����������1���������Ա�1���������Ա��������������ܱ�������������
 * @author Administrator
 * 1.�ж�һ�����Ƿ�Ϊ����
 * 2.�ҳ�һ����Χ�ڵ���������
 * 3.��ӡ�����е�����
 */
public class day04_zhishu {
	public static void main(String[] args) {
		System.out.print("1-10֮�ڵ������У�");
		for(int j = 1; j < 10; j++){//2.�����жϷ�Χ
			boolean isPrime = true;// Prime number������
			for(int i = 2;i <= j / 2;i ++){//i�ķ�Χ��[2,j/2]//1.�ж�����
				int m = j % i;
				if(m == 0){
					isPrime = false;
	//				System.out.println(j +"��������");
					break;//����forѭ��----Ҳ������continue(����)
				}
			}
			if(isPrime){//����isPrimeΪtrue����������С��4��������Ϊ���ܽ���forѭ�����������жϡ�
				System.out.print(j +"��");//3.��ӡ���
			}		
		}
//================================����ŵ�continue���÷������next(�ɸ���)
		nexe:for(int num = 2; num <= 100; num ++){
				for(int i = 2; i <= num/2; i++){
					if(num % i == 0){
						continue nexe;//��ϵ�ǰѭ��������ִ�б��Ϊnexe��Ӧ�����ѭ��
					}
				}
			System.out.println(num +"������");	
		}
	}
}
