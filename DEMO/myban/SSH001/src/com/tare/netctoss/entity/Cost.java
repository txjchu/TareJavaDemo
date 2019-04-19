package com.tare.netctoss.entity;

import java.sql.Date;

/**
 * 数据表Cost对应的实体类
 * @author Administrator
 *
 */
public class Cost {

	private Integer cost_id;//资费id主键
	private String name;//资费名称
	private Integer base_duration;//基本时长
	private Double base_cost;//基础费用
	private Double unit_cost;//单位费用
	private String status;//状态
	private String descr;//描述
	private Date creatime;//创建时间
	private Date startime;//开启时间
	private String cost_type;//资费类型
	public Integer getCost_id() {
		return cost_id;
	}
	public void setCost_id(Integer costId) {
		cost_id = costId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBase_duration() {
		return base_duration;
	}
	public void setBase_duration(Integer baseDuration) {
		base_duration = baseDuration;
	}
	public Double getBase_cost() {
		return base_cost;
	}
	public void setBase_cost(Double baseCost) {
		base_cost = baseCost;
	}
	public Double getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(Double unitCost) {
		unit_cost = unitCost;
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
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public Date getStartime() {
		return startime;
	}
	public void setStartime(Date startime) {
		this.startime = startime;
	}
	public String getCost_type() {
		return cost_type;
	}
	public void setCost_type(String costType) {
		cost_type = costType;
	}
	@Override
	public String toString() {
		return "Cost [cost_id=" + cost_id + ", name=" + name + ", base_cost="
				+ base_cost + ", base_duration=" + base_duration
				+ ", unit_cost=" + unit_cost + ", descr=" + descr + ", status="
				+ status + ", creatime=" + creatime + ", startime=" + startime
				+ ", cost_type=" + cost_type + "]";
	}
	
	
}
