package netctoss.service;
/**
 * 自定义异常：处理一个应用异常
 * @author Administrator
 *
 */
public class ApplicationException extends Exception {
	public ApplicationException() {
	}
	public ApplicationException(String message) {
		super(message);
	}
}

