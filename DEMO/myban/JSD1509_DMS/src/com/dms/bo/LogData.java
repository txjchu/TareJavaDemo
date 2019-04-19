package com.dms.bo;
/**
 * 该类用于表示unix 系统日志文件 wtmpx 中的一条日志信息。
 * @author Administrator
 *
 */
public class LogData {
	
	/*
	 * 定义常量
	 */
	/**
	 * 一条日志的长度（占用的字节量）
	 */
	public static final int LOG_LENGTH=372;
	
	/**
	 * USER用户名在一条日志中的起始位置
	 */
	public static final int USER_OFFSET = 0;
	/**
	 * USER在一条日志中占用的字节量
	 */
	public static final int USER_LENGTH = 32;
	/**
	 * PID在一条日志中的起始位置
	 */
	public static final int PID_OFFSET = 68;
	/**
	 * TYPE在一条日志中的起始位置----short型值，只能是7或者8
	 */
	public static final int TYPE_OFFSET = 72 ;
	/**
	 * TIME在一条日志中的起始位置
	 */
	public static final int TIME_OFFSET = 80;
	/**
	 * HOST在一条日志中的起始位置  + 长度
	 */
	public static final int HOST_OFFSET = 114;
	public static final int HOST_LENGTH = 258;
	
	/**
	 * 日志类型：登入日志
	 */
	public static final short TYPE_LOGIN = 7;
	/**
	 * 日志类型：登出日志
	 */
	public static final short TYPE_LOGOUT = 8;
	
	
	
	
	
	//用户名
	private String user;
	//进程ID
	private int pid;
	//日志类型
	private short type;
	//日志生成时间
	private int time;
	//用户的地址信息
	private String host;
	
	//创建一个无参参数
	public LogData(){
		
	}
	
	//生成构造方法----右键==>Source==>Generate Constructor using Fields...
	public LogData(String user, int pid, short type, int time, String host) {
		super();
		this.user = user;
		this.pid = pid;
		this.type = type;
		this.time = time;
		this.host = host;
	}

	/**
	 * 将给定的字符串转换为一个LogData实例。
	 * 前提是该字符串的格式必须是由该类toString方法生成的样式。
	 * @return
	 */
	public LogData(String log){			//----拆分
		String[] data = log.split(",");		
		this.user = data[0];
		this.pid  = Integer.parseInt(data[1]);
		this.type = Short.parseShort(data[2]);
		this.time = Integer.parseInt(data[3]);
		this.host = data[4];
	}
	
	//----生成GET-SET方法
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
	 * 格式：
	 * user,pid,type,time,host
	 */
	public String toString(){
		return user+","+pid+","+type+","+time+","+host;
	}
	
}
