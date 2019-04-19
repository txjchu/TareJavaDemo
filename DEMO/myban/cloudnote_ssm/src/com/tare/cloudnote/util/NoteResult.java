package com.tare.cloudnote.util;
/**
 * 封装了业务层和控制层业务方法的返回数据。
 * 作为服务器返回JSON数据类型的结果对象。
 * @author Administrator
 *
 */
public class NoteResult {

	private int status;//返回的状态码
	private String msg;//返回的消息
	private Object data;//返回的数据
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "NoteResult [status=" + status + ", msg=" + msg + ", data="
				+ data + "]";
	}
	
	
}
