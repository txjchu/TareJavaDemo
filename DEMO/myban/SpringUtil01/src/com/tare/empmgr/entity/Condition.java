package com.tare.empmgr.entity;

import java.util.List;

/**
 * Condition �������
 * ������ϰMyBatis�Ķ�̬SQL����
 * @author Administrator
 *
 */
public class Condition {

	private Integer deptno;			//���ű��
	private Double sal;				//Ա������
	private List<Integer> empnos;	//Ա����ż���
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
