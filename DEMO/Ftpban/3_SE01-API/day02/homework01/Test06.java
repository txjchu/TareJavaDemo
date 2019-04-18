package homework01;
/**
 * ื๗าต6
 * @author Administrator
 *
 */
public class Test06 {
	public static void main(String[] args) {
		StringBuilder builder
			= new StringBuilder();
		
		for(char c = '\u4e00',i=1;c<='\u9fa5';c++,i++){
			builder.append(c);
			if(i%50==0){
				builder.append("\n");
			}
		}
		System.out.println(builder.toString());
		
	}
}





