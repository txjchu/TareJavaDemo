package oo.day04;
//T型和J型测试类
public class TJTest {
	public static void main(String[] args) {
	T t=new T(2,5);
	t.print();

	J j=new J(3,4);
	j.print();
}
	
	
	//打墙+打T型
	public static void print(Tetromino t){
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				boolean flag=true;//1.假设打-
				for(int k=0;k<t.cells.length;k++){
					if(i==t.cells[k].row && j==t.cells[k].col){
						flag=false;//2.打*
						break;
					}
					
				}
				if(flag){//3.
					System.out.print("- ");
				}else{
					System.out.print("* ");
				}
				
								
			}
		System.out.println();
		}
	}
	
}









