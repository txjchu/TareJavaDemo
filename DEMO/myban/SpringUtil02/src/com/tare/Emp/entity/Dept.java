package com.tare.Emp.entity;

import java.util.List;

/**
 * Dept���Ӧ��ʵ����
 * @author Administrator
 *
 */

public class Dept {
	private Integer deptno;
	private String dname;
	private String loc;
	
	/*
	 * ���ڹ�����ѯ������ӳ��
	 */
	private List<Emp> emps;
	
	
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc
				+ "]";
	}
	
}
