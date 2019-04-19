package day04.copy;
/**
 * 使用匿名内部类的形式使用方式1和方式2创建Thread
 * @author Administrator
 *
 */
public class ThreadDemo03 {
	public static void main(String[] args) {
		//方式1：直接继承Thread
		Thread t1 = new Thread(){
			public void run(){
				for(int i = 0; i < 1000; i ++){
					System.out.println("你是谁啊？");
				}
			}
		};
		//方式2：实现Runnable接口
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i = 0; i < 1000; i++){
					System.out.println("我是查水表的...");
				}
			}
		});
		t1.start();
		t2.start();
		System.out.println("程序结束了！");//------???最先输出
	}
}
















