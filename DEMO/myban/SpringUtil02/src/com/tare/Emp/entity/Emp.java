package com.tare.Emp.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 数据表Emp对应的实体类
 * @author Administrator
 *
 */
public class Emp implements Serializable{
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Double comm;
	private Integer mgr;
	private Integer deptno;
	private Date hiredate;
	
	/*
	 * 关联属性：用于封装员工的部门信息。
	 */
	private Dept dept;
	
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ ", sal=" + sal + ", comm=" + comm + ", mgr=" + mgr
				+ ", deptno=" + deptno + ", hiredate=" + hiredate + "]";
	}
	
	
}
