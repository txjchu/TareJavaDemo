package day04.case04;
/**
 * °¸Àý4
 * 
 * @author Administrator
 *
 */
public class TestThreadNameAndId {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		System.out.println("t1:"+ t1.getName() +","+ t1.getId());//t1:Thread-0,8
		Thread t2 = new Thread();
		System.out.println("t2:"+ t2.getName() +","+ t2.getId());//t2:Thread-1,9
		
		Thread t3 = new Thread("thread");
		System.out.println("t3:"+ t3.getName() +","+ t3.getId());//t3:thread,10
	}
}
