package day05;
//��ҵ����
public class Homework05 {

	public static void main(String[] args) {
	
	int num=67;
	boolean flag=true;//1.
	//for (int i=2;i<num;i++){
	//for (int i=2;i<num/2;i++){---------------�Ż�
	for(int i=2;i<=Math.sqrt(num);i++){
		if(num%i==0){
			flag=false;//2.
			break;
		}
	}
	if(flag==true){ //3.���Լ�дΪ(fang)��if���汾������boolean��
		System.out.println(num+"������");
	}else{
		System.out.println(num+"��������");
	}
	}

}
