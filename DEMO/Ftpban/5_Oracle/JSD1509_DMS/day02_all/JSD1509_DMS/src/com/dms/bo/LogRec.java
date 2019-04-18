package com.dms.bo;
/**
 * 该类的每一个实例用于表示一组配对日志
 * @author Administrator
 *
 */
public class LogRec {
	private LogData login;
	private LogData logout;
	public LogRec(LogData login, LogData logout) {
		super();
		this.login = login;
		this.logout = logout;
	}
	public LogData getLogin() {
		return login;
	}
	public void setLogin(LogData login) {
		this.login = login;
	}
	public LogData getLogout() {
		return logout;
	}
	public void setLogout(LogData logout) {
		this.logout = logout;
	}
	/**
	 * toString格式:
	 * login.toString()|logout.toString()
	 */
	public String toString(){
		return login+"|"+logout;
	}
}




