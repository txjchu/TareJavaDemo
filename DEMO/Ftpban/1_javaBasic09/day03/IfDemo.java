package day03;
//��֧�ṹ��ʾ
public class IfDemo {
	public static void main(String[] args) {
		int num = 8;
		switch(num){ //byte,short,int,char
		case 1: //�൱��if(num==1)
			System.out.println(111);
			break;
		case 2: //�Դ�Ϊ���
			System.out.println(222);
			break; //����switch
		case 3:
			System.out.println(333);
			break;
		default: //����д���κ�λ�ã���������case��û����ʱ����
			System.out.println(444);
		}
		
		
		
		
		
		
		
		
		
		
		
		/*
		int num = 5;
		if(num%2==0){
			System.out.println(num+"��ż��");
		}else{
			System.out.println(num+"������");
		}
		System.out.println("over");
		*/
		
		/*
		int num = 5;
		if(num%2==0){
			System.out.println(num+"��ż��");
		}
		System.out.println("over");
		*/
	}
}











