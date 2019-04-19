package com.tarena.demo.entity;

import java.io.Serializable;
import java.sql.Date;

//entity��ʾʵ��

public class Emp implements Serializable{
	//ʵ����ͨ����ʵ��һ���ӿڣ�Serializable----�����л���
	/**
	 * Empʵ����
	 * �Զ�����һ���汾�ţ���̾�ţ�
	 */
	private static final long serialVersionUID = 1L;
	
	//������	----���ݿ��е��ֶ���
	private Integer empno;//----��������ʽ����һ����ĸСд���ڶ�����ĸ����ĸ��д
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Integer deptno;
	private Integer mgr;
	private Date hiredate;//----������SQL�����DATE
	
	
	private Dept dept;//----������Dept �����
	
	//������-----ֻҪ������һ���вεģ����뻹Ҫ����һ���޲εġ�
	public Emp(){}
	
	public Emp(Integer empNo, String ename, String job, double sal,
			double comm, Integer deptNo, Integer mgr, Date hiredate) {
		super();
		this.empno = empNo;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptNo;
		this.mgr = mgr;
		this.hiredate = hiredate;
	}
	
	
	
	//����get��set����
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empNo) {
		this.empno = empNo;
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
	public void setDeptno(Integer deptNo) {
		this.deptno = deptNo;
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

	//----����equals��hashCode
	//----hashCode�ṩ��һ������
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
	
	public Dept getDept() {
		return dept;
	}

	@Override
	public String toString() {
		return "Emp [comm=" + comm + ", deptNo=" + deptno + ", empNo=" + empno
				+ ", ename=" + ename + ", hiredate=" + hiredate + ", job="
				+ job + ", mgr=" + mgr + ", sal=" + sal + "]";
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
		
	



}
