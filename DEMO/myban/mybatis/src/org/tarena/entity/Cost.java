package org.tarena.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 实体类
 * 1.实现序列化Serializable(为了a.网络中对象传递，b.磁盘文件读写。)
 * 2.属性类型采用封装类型，尤其是框架。(封装类包含null,可以降低出错几率。)
 * 3.属性名称与字段名一致。(仅限于MyBatis)
 * 
 */
public class Cost implements Serializable {
	
	private Integer cost_id;
	private String name;
	private Long base_duration;
	private Double base_cost;
	private Double unit_cost;
	private String status;
	private String descr;
	private Date creatime;
	private Date startime;
	private String cost_type;
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
	public Long getBase_duration() {
		return base_duration;
	}
	public void setBase_duration(Long baseDuration) {
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
	
	
}
