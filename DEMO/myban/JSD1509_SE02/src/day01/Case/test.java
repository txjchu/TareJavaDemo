package day01.Case;
/**
 * �����ļ���  2-100֮����ٸ�����
 * @author Administrator
 *
 */
public class test {
	public static void main(String[] args) {
/*		
		int count = 0;
		for(int i = 1; i <= 100; i ++){
			for(int j = 2; j <= i; j++){
				if(i == j){
					count ++;
					System.out.print(i + " ");
					if(count % 10 == 0){
						System.out.println();
					}
				}
				if(i % j == 0){
					break;
				}
			}
		}
		System.out.println("������"+ count);
*/		
		
///*		
		int count = 0; //����������������
		for(int i = 2; i <= 100; i ++){
			boolean flag = true;//����iΪ����
			//������ֻ�ܱ�1��������������Ȼ����һ������û�б�һ��С����ƽ�������������������Ȼ���ᱻ������ƽ��������������
			for(int j = 2; j <= Math.sqrt(i); j ++){//��������ʱ����Ҫ����j = i�������Ӽ���ɱ�				
				if(i % j == 0){//������������������Ϊ������
					flag = false;
					break;//������ǰѭ��
				}
			}
			if(flag){//�����ȡ���˴�����i����������flag����Ϊtrue
				count ++;//����������1
				System.out.print(i + " ");
				if(count % 10 == 0){//ÿ10�����ֻ�һ��
					System.out.println();
				}
			}
		}
		System.out.println("\n2-100֮��һ���У�"+ count +"��������");
//*/
	}
}









