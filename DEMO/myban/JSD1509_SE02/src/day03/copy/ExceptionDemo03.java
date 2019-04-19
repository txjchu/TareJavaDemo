package day03.copy;



/**
 * 抛出异常
 * throw关键字可以主动抛出一个异常的实例。
 * 通常有两种情况我们会主动向方法外抛出一个异常：
 * 1.当前代码不负责异常的处理（责任制问题，通知调用者出错了。）
 * 2.出现一个满足语法要求（即没有编译错误），但是不满足业务逻辑要求时。
 *  
 * @author Administrator
 *
 */
public class ExceptionDemo03 {
	public static void main(String[] args) {
		Person p = new Person();
		try{
			/*
			 * 当调用一个含有throws声明抛出检查异常的方法时，编译器会在编译代码过程中会检查我们调用该方法时是否
			 * 有处理异常的手段，处理手段有两种：
			 * 1.使用try-catch捕获并处理该异常
			 * 2.在当前方法上继续使用throws抛出该异常。
			 * 但是永远不要在main方法上声明throws。
			 */
			p.setAge(213);
		}catch(ageException e){
			System.out.println("抓到一个ageException");
			System.out.println(e.getMessage());
			/*
			 * 输出结果：
			 * 抓到一个ageException
			 * 不符合人类年龄
			 */
		}catch(Exception e){
			System.out.println("从调用的方法中捕获一个异常!");
		}
		System.out.println("年龄是："+ p.getAge());//年龄是：0
	}
}
















