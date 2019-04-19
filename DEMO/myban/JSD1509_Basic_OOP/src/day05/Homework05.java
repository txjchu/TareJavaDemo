package day05;
//作业讲解
public class Homework05 {

	public static void main(String[] args) {
	
	int num=67;
	boolean flag=true;//1.
	//for (int i=2;i<num;i++){
	//for (int i=2;i<num/2;i++){---------------优化
	for(int i=2;i<=Math.sqrt(num);i++){
		if(num%i==0){
			flag=false;//2.
			break;
		}
	}
	if(flag==true){ //3.可以简写为(fang)，if里面本来就是boolean型
		System.out.println(num+"是质数");
	}else{
		System.out.println(num+"不是质数");
	}
	}

}
