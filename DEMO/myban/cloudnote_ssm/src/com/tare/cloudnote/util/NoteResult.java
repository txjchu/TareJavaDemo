package com.tare.cloudnote.util;
/**
 * ��װ��ҵ���Ϳ��Ʋ�ҵ�񷽷��ķ������ݡ�
 * ��Ϊ����������JSON�������͵Ľ������
 * @author Administrator
 *
 */
public class NoteResult {

	private int status;//���ص�״̬��
	private String msg;//���ص���Ϣ
	private Object data;//���ص�����
	
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
