package com.dms.bo;
/**
 * �������ڱ�ʾunix ϵͳ��־�ļ� wtmpx �е�һ����־��Ϣ��
 * @author Administrator
 *
 */
public class LogData {
	
	/*
	 * ���峣��
	 */
	/**
	 * һ����־�ĳ��ȣ�ռ�õ��ֽ�����
	 */
	public static final int LOG_LENGTH=372;
	
	/**
	 * USER�û�����һ����־�е���ʼλ��
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
	 * TYPE��һ����־�е���ʼλ��----short��ֵ��ֻ����7����8
	 */
	public static final int TYPE_OFFSET = 72 ;
	/**
	 * TIME��һ����־�е���ʼλ��
	 */
	public static final int TIME_OFFSET = 80;
	/**
	 * HOST��һ����־�е���ʼλ��  + ����
	 */
	public static final int HOST_OFFSET = 114;
	public static final int HOST_LENGTH = 258;
	
	/**
	 * ��־���ͣ�������־
	 */
	public static final short TYPE_LOGIN = 7;
	/**
	 * ��־���ͣ��ǳ���־
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
	
	//����һ���޲β���
	public LogData(){
		
	}
	
	//���ɹ��췽��----�Ҽ�==>Source==>Generate Constructor using Fields...
	public LogData(String user, int pid, short type, int time, String host) {
		super();
		this.user = user;
		this.pid = pid;
		this.type = type;
		this.time = time;
		this.host = host;
	}

	/**
	 * ���������ַ���ת��Ϊһ��LogDataʵ����
	 * ǰ���Ǹ��ַ����ĸ�ʽ�������ɸ���toString�������ɵ���ʽ��
	 * @return
	 */
	public LogData(String log){			//----���
		String[] data = log.split(",");		
		this.user = data[0];
		this.pid  = Integer.parseInt(data[1]);
		this.type = Short.parseShort(data[2]);
		this.time = Integer.parseInt(data[3]);
		this.host = data[4];
	}
	
	//----����GET-SET����
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
	 * ��ʽ��
	 * user,pid,type,time,host
	 */
	public String toString(){
		return user+","+pid+","+type+","+time+","+host;
	}
	
}
