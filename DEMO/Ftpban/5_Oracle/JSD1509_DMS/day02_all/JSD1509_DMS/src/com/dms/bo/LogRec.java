package com.dms.bo;
/**
 * �����ÿһ��ʵ�����ڱ�ʾһ�������־
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
	 * toString��ʽ:
	 * login.toString()|logout.toString()
	 */
	public String toString(){
		return login+"|"+logout;
	}
}




