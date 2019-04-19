package com.tarena.demo.entity;

import java.io.Serializable;
import java.sql.Date;

//entity表示实体

public class Emp implements Serializable{
	//实体类通常都实现一个接口，Serializable----可序列化的
	/**
	 * Emp实体类
	 * 自动生成一个版本号（感叹号）
	 */
	private static final long serialVersionUID = 1L;
	
	//属性类	----数据库中的字段名
	private Integer empNo;//----属性名格式，第一个字母小写，第二个字母首字母大写
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Integer deptNo;
	private Integer mgr;
	private Date hiredate;//----导包：SQL里面的DATE
	
	
	private Dept dept;//----创建类Dept 后，添加
	
	//构造器-----只要定义了一个有参的，必须还要生成一个无参的。
	public Emp(){}
	
	public Emp(Integer empNo, String ename, String job, double sal,
			double comm, Integer deptNo, Integer mgr, Date hiredate) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
		this.deptNo = deptNo;
		this.mgr = mgr;
		this.hiredate = hiredate;
	}
	
	
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	//生成get和set方法
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
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
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
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

	//----生成equals和hashCode
	//----hashCode提供了一个方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
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
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		return true;
	}
	
	
}





