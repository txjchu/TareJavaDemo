package netctoss.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Costʵ����		cost ���ѷ���
 * @author Administrator
 *
 */
public class Cost implements Serializable{
	private Integer costId;				//�ײ�ID
	private String name;				//�ײ�����
	private Integer baseDuration;		//����ʱ��		duration ����
	private Double baseCost;			//��������
	private Double unitCost;			//��λ����
	private String status;				//��ͨ״̬
	private String descr;				//������
	private Timestamp creatime;			//����ʱ��
	private Timestamp startime;			//����ʱ��
	private String costType;			//�ײ�����
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
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
