package a01;
//����1+..+10000000�ĺ��Լ���ʱ
public class sum1_1000000 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.err.println(startTime);
		int sum = 0;
		for(int i=1;i<=10000000;i++){
			sum += i;
		}
//        int sum = 0;
//        System.out.println(sum);
//        for (int i = 1; i <= 10000000; i++) {
//           sum+=i;
//        }
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);
		System.err.println("��ʱ��"+(endTime-startTime)+"����");
		
		
		double a1 = 6.0;
		double a2 = 4.9;
		System.out.println(a1-a2);
		
		//��˹���� ascr
		char ascr2 = 98;
		System.out.println(ascr2);
		
		for(int i=1;i<=110;i++){
			char ascr = 0;
			ascr += i;
			System.out.println(i+":"+ascr);
		}
	}

}
