package entity;

import java.io.Serializable;
/**
 * course过程，进程，道路，v.追赶，跑过，指引航线。
 * 课时安排实体类
 * @author Administrator
 *
 */
public class Course implements Serializable {
	private int id;
	private String name ;
	private int days;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
}
