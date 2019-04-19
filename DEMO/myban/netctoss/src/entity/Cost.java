package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cost implements Serializable {
	
	//1.
	//写实体类时候用封装类型Integer，因为多了一个null值。【】
	private Integer costID;		//资费ID	
	private String name;		//资费名
	private Integer baseDuration;	//基本时常----套餐中可通话时常
	private Double baseCost;	//基本费用
	private Double unitCost;	//单位费用
	private String status;		//状态：0-开通，1-暂停
	private String descr;		//描述
	//实体类中创建具体时间类型用java.sql.Timestamp类----见笔记图片Date
	private Timestamp creatime;		//创建时间
	private Timestamp startime;		//开通时间
	private String costType;		//资费类型:1.包月，2.套餐，3.计时。
	//2.生成get-set方法
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
