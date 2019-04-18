package org.tarena.note.util;

import java.io.Serializable;

public class Page implements Serializable{
	private int current;//�ڼ�ҳ
	private int pageSize;//һҳ����
	
	//SQL����#{begin}��ȡ
	public int getBegin(){
		int begin = (current-1)*pageSize;
		return begin;
	}
	
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
