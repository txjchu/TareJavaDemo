package day03.copy;
/**
 * 用于辅助测试异常，throws
 * @author Administrator
 *
 */
public class Person {
	private int age;

	public int getAge() {
		return age;
	}
	
	/*
	 * throws用于在方法上定义该方法可能抛出的异常，这样做的目的是通知调用者必须要处理可能抛出的异常。
	 * 好处是，调用者不会因为该方法抛出一个异常而没有解决导致程序中断。
	 * 什么时候需要在方法上声明throws抛出异常：
	 * 1.当方法中使用throw抛出一个检查异常
	 * （非RuntimeException及子类）实例时，我们可以在方法上声明该异常的抛出通知调用者。
	 * 2.当前方法调用了一个含有throws声明的方法时，该方法仍然不处理这个异常时，可以在当前方法上继续使用throws声明
	 * 这个异常的抛出，通知上层调用者解决。
	 */
	public void setAge(int age) throws ageException{
		if(age < 0 || age > 100){
			throw new ageException("不符合人类年龄");
		}
		this.age = age;
	}
	
}



















