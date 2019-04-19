package org.tarena.entity;

import java.io.Serializable;
import java.sql.Date;

public class MyCost implements Serializable {
	private Integer id;
	private String name;
	private Long duration;
	private Double basecost;
	private Double unitcost;
	private String status;
	private String descr;
	private Date creatime;
	private Date startime;
	private String costtype;
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
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Double getBasecost() {
		return basecost;
	}
	public void setBasecost(Double basecost) {
		this.basecost = basecost;
	}
	public Double getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(Double unitcost) {
		this.unitcost = unitcost;
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
	public String getCosttype() {
		return costtype;
	}
	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}
	
	
}
