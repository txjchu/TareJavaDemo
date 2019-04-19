package com.tare.empmgr.entity;

import java.util.List;

/**
 * Condition 情况条件
 * 用于练习MyBatis的动态SQL技术
 * @author Administrator
 *
 */
public class Condition {

	private Integer deptno;			//部门编号
	private Double sal;				//员工工资
	private List<Integer> empnos;	//员工编号集合
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public List<Integer> getEmpnos() {
		return empnos;
	}
	public void setEmpnos(List<Integer> empnos) {
		this.empnos = empnos;
	}
	@Override
	public String toString() {
		return "Condition [deptno=" + deptno + ", empnos=" + empnos + ", sal="
				+ sal + "]";
	}
	
	
}
