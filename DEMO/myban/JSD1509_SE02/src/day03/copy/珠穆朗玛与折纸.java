package day03.copy;

import org.junit.Test;

/**
 * ��Ŀ�����ֱ���forѭ����whileѭ��ʵ�֣�
 * 1.���������߶�Ϊ8848�ף���һ���㹻���ֽ�����Ϊ0.0001�ס�
 * 2.���ʣ��۵����ٴΣ������۳����������ĸ߶ȡ�
 * @author Administrator
 *
 */
public class ������������ֽ {
	
	//whileѭ��
	@Test
	public void testWhile(){
		
		System.out.println(1.22 > 1);//true
		System.out.println(1.001 < 1);//flase
		System.out.println(0.00009 < 1);//true
		System.out.println(1 < 0.008);//flase
				
		long count = 0L;	 //���۵�����
		long h = 8848L;		 //��ĸ߶�
		double ply = 0.0001;//ֽ�ĺ��	ply ���
		double plys = 0;
		while(plys < h){
			ply *= 2;//��һ�Σ�ֽ�ĺ��x2��
			plys = ply;
			count ++;//������1
		}
		System.out.println(plys);
		System.out.println("һ������"+ count +"�Σ�");
	}
	
	@Test
	//forѭ��
	public void testFor(){
		long count = 0L;		//���۵�����
		long h = 8848L;			//��ĸ߶�
		double ply = 0.0001;	//ֽ�ĺ�� 
		double plys = 0L;
		for(int i = 0; ; i++){
			ply *= 2;			//�۵�һ��plyֽ�ĺ��x2
			plys = ply;
			count ++;
			if(plys >= h){
				break;
			}
		}
		System.out.println(plys);
		System.out.println("һ���۵���"+ count +"�Σ�");
	}
}
