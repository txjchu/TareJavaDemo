package day05;
//��ӡ�˷��ھ���
public class MuiltTable {
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){//-----������д10��arr.length
		 
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
	for(int num=1;num<=9;num++){      //������
		for (int i=1;i<=num;i++){     //������
			System.out.print(i+"*"+num+"="+i*num+"\t");// "\t"����һ��Tab		
			}
			System.out.println();     //����
		}
		*/
	/*
	 * ִ�й��̣�
	 * num=1
	 * 	i=1 1*1=1
	 *  i=2   ����------���������num++
	 * num=2
	 * 	i=1 1*2=2
	 *  i=2 2*2=4
	 *  i=3   ����
	 * num=3
	 *  i=1 1*3=3
	 *  i=2 2*3=6
	 *  i=3 3*3=9
	 *  i=4   ����
	 * num=4
	 * .
	 * .
	 * . 
	 */
	}
}
