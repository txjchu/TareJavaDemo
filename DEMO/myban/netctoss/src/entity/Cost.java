package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cost implements Serializable {
	
	//1.
	//дʵ����ʱ���÷�װ����Integer����Ϊ����һ��nullֵ������
	private Integer costID;		//�ʷ�ID	
	private String name;		//�ʷ���
	private Integer baseDuration;	//����ʱ��----�ײ��п�ͨ��ʱ��
	private Double baseCost;	//��������
	private Double unitCost;	//��λ����
	private String status;		//״̬��0-��ͨ��1-��ͣ
	private String descr;		//����
	//ʵ�����д�������ʱ��������java.sql.Timestamp��----���ʼ�ͼƬDate
	private Timestamp creatime;		//����ʱ��
	private Timestamp startime;		//��ͨʱ��
	private String costType;		//�ʷ�����:1.���£�2.�ײͣ�3.��ʱ��
	//2.����get-set����
	public Integer getCostID() {
		return costID;
	}
	public void setCostID(Integer costID) {
		this.costID = costID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Timestamp getCreatime() {
		return creatime;
	}
	public void setCreatime(Timestamp creatime) {
		this.creatime = creatime;
	}
	public Timestamp getStartime() {
		return startime;
	}
	public void setStartime(Timestamp startime) {
		this.startime = startime;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	
	
	
}
