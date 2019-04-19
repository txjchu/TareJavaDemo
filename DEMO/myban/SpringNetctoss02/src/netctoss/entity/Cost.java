package netctoss.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * Cost表的实体类
 * @author Administrator
 *
 */
public class Cost implements Serializable{
	private Integer cost_id;
	private String name;
	private Integer bast_duration;
	private Integer bast_cost;
	private Integer unit_cost;
	private String status;
	private String descr;
	private Timestamp creatime;
	private Timestamp startime;
	
	@Override
	public String toString() {
		return "Cost:[cost_id:"+cost_id+"name:"+name+"bast_duration:"+bast_duration+
				"bast_cost:"+bast_cost+"unit_cost:"+unit_cost+"status:"+status+"descr:"+
				descr+"creatime:"+creatime+"startime:"+startime+"]";
	}
	
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
	public Integer getBast_duration() {
		return bast_duration;
	}
	public void setBast_duration(Integer bastDuration) {
		bast_duration = bastDuration;
	}
	public Integer getBast_cost() {
		return bast_cost;
	}
	public void setBast_cost(Integer bastCost) {
		bast_cost = bastCost;
	}
	public Integer getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(Integer unitCost) {
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
	
	
}
