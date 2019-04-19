package day02;
//作业题第6题，打印所有汉字
public class HomeWorkCharTest {
	public static void main(String[] args) {
		StringBuilder builder=new StringBuilder();
	for(char c='\u4e00',i=1;c<='\u9fa5';c++,i++){
		builder.append(c);
		if(i%50==0){
			builder.append("\n");
		}
	}
	System.out.println(builder);
	}
}
