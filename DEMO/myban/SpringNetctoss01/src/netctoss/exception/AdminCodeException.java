package netctoss.exception;
/**
 * 登录异常-自定义异常类
 * @author Administrator
 *
 */
public class AdminCodeException extends RuntimeException{
	
	public AdminCodeException() {
		super();
	}
	public AdminCodeException(String message) {
		super(message);	
	}
	
	
}
