package com.dms.bo;
/**
 * �������ڱ�ʾunixϵͳ��־�ļ�wtmpx�е�
 * һ����־��Ϣ��
 * @author Administrator
 *
 */
public class LogData {
	/*
	 *	��������
	 */
	/**
	 * һ����־�ĳ���(ռ�õ��ֽ���)
	 */
	public static final int LOG_LENGTH = 372;
	/**
	 * USER��һ����־�е���ʼλ��
	 */
	public static final int USER_OFFSET = 0;
	/**
	 * USER��һ����־��ռ�õ��ֽ���
	 */
	public static final int USER_LENGTH = 32;
	/**
	 * PID��һ����־�е���ʼλ��
	 */
	public static final int PID_OFFSET = 68;
	/**
	 * TYPE��һ����־�е���ʼλ��
	 */
	public static final int TYPE_OFFSET = 72;
	/**
	 * TIME��һ����־�е���ʼλ��
	 */
	public static final int TIME_OFFSET = 80;
	/**
	 * HOST��һ����־�е���ʼλ��
	 */
	public static final int HOST_OFFSET = 114;
	/**
	 * HOST��һ����־�еĳ���
	 */
	public static final int HOST_LENGTH = 258;
	
	/**
	 * ��־����:������־
	 */
	public static final short TYPE_LOGIN = 7;
	/**
	 * ��־����:�ǳ���־
	 */
	public static final short TYPE_LOGOUT = 8;
	
	//�û���
	private String user;
	//����ID
	private int pid;
	//��־����
	private short type;
	//��־����ʱ��
	private int time;
	//�û��ĵ�ַ��Ϣ
	private String host;
	
	public LogData(){
		
	}

	public LogData(String user, int pid, short type, int time, String host) {
		super();
		this.user = user;
		this.pid = pid;
		this.type = type;
		this.time = time;
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * ��ʽ:
	 * user,pid,type,time,host
	 */
	public String toString(){
		return user+","+pid+","+
	           type+","+time+","+
			   host;
	}
}






