package org.tare.entity;
/**
 * 部门实体类
 * @author Administrator
 *
 */
public class Dept {
	private Integer no;
	private String name;
	private String loc;
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer deptno) {
		this.no = deptno;
	}
	public String getName() {
		return name;
	}
	public void setName(String dname) {
		this.name = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + no + ", dname=" + name + ", loc=" + loc
				+ "]";
	}
	
}
