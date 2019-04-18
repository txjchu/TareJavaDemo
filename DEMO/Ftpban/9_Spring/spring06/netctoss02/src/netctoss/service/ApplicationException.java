package netctoss.service;
/**
 * 自定义异常
 *
 */
public class ApplicationException 
extends RuntimeException {

	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}
	
}
