package netctoss.exception;
/**
 * 自定义异常：用户账号相关异常
 * @author Administrator
 *
 */

public class AdminCodeException extends RuntimeException{
	
	public AdminCodeException(){
		super();
	}
	public AdminCodeException(String message){
		super(message);
	}
}
