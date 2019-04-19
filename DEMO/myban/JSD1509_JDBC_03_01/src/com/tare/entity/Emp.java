package com.tare.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Emp实体类
 * 
 * @author Administrator
 * 
 */
public class Emp implements Serializable {
	/**
	 * 实现可序列化的接口后，可以自动添加的一个版本号 
	 */
	private static final long serialVersionUID = 1L;
	//属性成员变量
	private Integer empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Integer deptno;
	private Integer mgr;
	private Date hiredate;
	
	private Dept dept;

	//构造器
	public Emp(){}
	public Emp(Integer empno, String ename, String job, double sal,
			double comm, Integer deptno, Integer mgr, Date hiredate) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
		this.mgr = mgr;
		this.hiredate = hiredate;
	}
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	//自动生成hashCode()和equals()方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empno == null) ? 0 : empno.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empno == null) {
			if (other.empno != null)
				return false;
		} else if (!empno.equals(other.empno))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Emp [comm=" + comm + ", deptno=" + deptno + ", empno=" + empno
				+ ", ename=" + ename + ", hiredate=" + hiredate + ", job="
				+ job + ", mgr=" + mgr + ", sal=" + sal + "]";
	}
	
	
	
	
	
}










