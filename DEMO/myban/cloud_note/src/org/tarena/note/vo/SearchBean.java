package org.tarena.note.vo;

import java.io.Serializable;
import java.sql.Date;

public class SearchBean implements Serializable {
	
	private String title;//����
	private String status;//״̬
	private String beginTime;//��ʼʱ��--(date������html��������Ҫ��������,����ı����в�����ΪNull��Date��ʽ������)
	private String endTime;//����ʱ��
	
	//#{longEndTime}
	public Long getLongEndTime(){
		if(endTime == null || "".equals(endTime)){
			return null;
		}else{
			Date time = Date.valueOf(endTime);
			return time.getTime();
		}
	}
	
	//#{longBeginTime}
	//���������String��������ת��Long��ʾ
	public Long getLongBeginTime(){
		if(beginTime == null || "".equals(beginTime)){
			return null;
		}else{
			Date time = Date.valueOf(beginTime);
			return time.getTime();
		}
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
