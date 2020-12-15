package com.pc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工实体类
 * @author: Peter
 * @date: 2020/12/12 21:37
 */
public class Emp implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    /**
     * 笔记
     * 1.jsp 中提交的 Date 字段，需要在 bean 属性上，或 set 方法上使用 @DateTimeFormat 方法来进行将提交过来的字符串数据使用 SimpleDateFormat 解析为 Date 类型。
     * 2. 或者手动在 set 方法中使用 SimpleDateFormat 进行转换。
     * 3. 另外2种方法参考：[SpringMVC 四种方法解决表单到后台的日期类型转换](https://blog.csdn.net/wn084/article/details/80171687)
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;  // hiredate 入职时间
    private Double sal;
    private Double comm;
    private Integer deptno;

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
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

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }
}
