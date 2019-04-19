package day05;
//打印乘法口诀表
public class MuiltTable {
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){//-----不建议写10，arr.length
		 
	        System.out.println(arr[arr.length-1]);
	        }
		
		
	    for(int num=1;num<=9;num++){
	    	for(int i=1;i<=9;i++){
	    		if(i<=num){
	    			System.out.print(i+"*"+num+"="+i*num+"\t");
	    		}
	    	}
	    	System.out.println();
	    }
		
		
		
		
		
/*
	for(int num=1;num<=9;num++){      //控制行
		for (int i=1;i<=num;i++){     //控制列
			System.out.print(i+"*"+num+"="+i*num+"\t");// "\t"加了一个Tab		
			}
			System.out.println();     //换行
		}
		*/
	/*
	 * 执行过程：
	 * num=1
	 * 	i=1 1*1=1
	 *  i=2   换行------换行完后走num++
	 * num=2
	 * 	i=1 1*2=2
	 *  i=2 2*2=4
	 *  i=3   换行
	 * num=3
	 *  i=1 1*3=3
	 *  i=2 2*3=6
	 *  i=3 3*3=9
	 *  i=4   换行
	 * num=4
	 * .
	 * .
	 * . 
	 */
	}
}
