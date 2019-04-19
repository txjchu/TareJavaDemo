package day03.copy;
/**
 * 练习自定义异常
 * 自定义异常通常用来描述一个系统业务及的错误
 * @author Administrator
 *
 */
public class ageException extends Exception{
	/*
	 * 版本号
	 */
	private static final long serialVersonUID = 1L;

	//自动生成继承父类的构造方法	Generated Constructor from Superclass
	public ageException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ageException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ageException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ageException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
