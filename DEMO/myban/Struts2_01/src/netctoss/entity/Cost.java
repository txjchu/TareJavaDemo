package netctoss.entity;

import java.sql.Date;

/**
 * ���ݱ�COST��Ӧ��ʵ����
 * @author Administrator
 *
 */

public class Cost {
    private Integer id;// ����
    private String name;// �ʷ�����
    private Integer baseDuration;// ����ʱ��
    private Double baseCost;// ��������
    private Double unitCost;// ��λ����
    private String status;// ״̬
    private String descr;// �ʷ�˵��
    private Date createTime;// ��������
    private Date startTime;// ��������
    private String costType;// �ʷ�����
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	@Override
	public String toString() {
		return "Cost [id=" + id + ", name=" + name + ", baseCost=" + baseCost
				+ ", unitCost=" + unitCost + ", baseDuration=" + baseDuration
				+ ", costType=" + costType + ", createTime=" + createTime
				+ ", startTime=" + startTime + ", status=" + status
				+ ", descr=" + descr + "]";
	}
    
    
    
}
