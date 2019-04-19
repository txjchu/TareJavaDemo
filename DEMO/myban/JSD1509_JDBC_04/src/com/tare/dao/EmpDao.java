package com.tare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tarena.demo.entity.Dept;
import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * Dao Data Access Object ���ݷ��ʶ���
 * EmpDaoʵ��ORM(Object/Relation Mapping)�����ϵӳ��-java�еĶ�������ݿ��ϵ���໥ӳ�䡣
 * 
 * @author Administrator
 *
 */
public class EmpDao {
	/**
	 * ��ɶ��������ݿ�֮�����ɾ�Ĳ������
	 */
	/*
	 * ��������Emp����
	 */
	public boolean add(Emp emp){
		String sql = "insert into emp values(empseq.nextval, ?, ?, ?, ?, ?, ?, ?)";//����Ԥ����SQL���
		//����
		Connection conn = null;//�������Ӷ���
		PreparedStatement ps = null;//����Ԥ����������
		int flag = 0;//������������ݵķ���������Ӱ��ļ�¼��
		//ʵ����
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			//װ�ز���
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			//ִ��insert
//			ps.executeUpdate();
			flag = ps.executeUpdate();//��ȡ�Ƿ�ɹ�
			if(flag != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ���Ӷ����쳣��");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}		
		return false;
	}
	/*
	 * ɾ����Ա�����ɾ�����ݿ���е�����
	 */
	public boolean delete(Integer empno){
		String sql = "delete from emp where empno = ?";
		//����
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			flag = ps.executeUpdate();//��ɾ���ɹ��򷵻�Ӱ��ļ�¼��
			if(flag != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ���Ӷ����쳣");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}
		return false;
	}
	/*
	 * �ģ��޸����ݿ���еļ�¼
	 */
	public boolean update(Emp emp){
		String sql = "update emp set ename = ?, job = ?, mgr = ?, hiredate = ?," +
				" sal = ?, comm = ?, deptno = ? where empno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			flag = ps.executeUpdate();
			if(flag != 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ���Ӷ���ʧ�ܣ�");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}		
		return false;//���м���쳣�ˣ��򲻻�ִ�г��쳣������Ĵ��롣���Ӧ�÷ŵ�try-catch-finally����
	}
	/*
	 * �飺1.ͨ��Ա����Ų��Ա����Ϣ
	 */
	public Emp findByEmpno(Integer empNo){
		String sql = "select empno, ename, job, mgr, sal, comm, hiredate, deptno from emp where empno = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;//���մ����ݿ��д������Ľ��������
		Emp emp = null;//�����������ת��Ϊʵ����ľ������
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empNo);
			rs = ps.executeQuery();
			while(rs.next()){
				emp = empMapper(rs);//��������е����ݸ�ֵ��Emp����
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���������쳣��");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return emp;
	}
	/*
	 * ���������ݿ��������ӳ��ķ���
	 * �÷�����������е�һ����¼ת��Ϊһ��Emp����ORM(Object/Relation Mapping)
	 */
	public Emp empMapper(ResultSet rs) throws SQLException{
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setSal(rs.getDouble("sal"));
		emp.setComm(rs.getDouble("comm"));
		emp.setDeptno(rs.getInt("deptno"));
		emp.setHiredate(rs.getDate("hiredate"));
		//��������ȡ��ֵ��Ϊ���жϵģ����ɸ�ֵ��ֵ������ĳ�Ա�����ϣ����������Ƹ����Եĸ�ֵ��
			emp.setMgr(rs.getInt("mgr"));			
		
		emp.setJob(rs.getString("job"));	
		
		return emp;
	}
	/*
	 * �飺2.������е�Ա����Ϣ
	 */
	public List<Emp> findAll(){
		String sql = "select empno, ename, job, mgr, sal, comm, hiredate, deptno from emp";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();//���ڽ���ת��������Emp����
//		List<Emp> emps = null;	//java.lang.NullPointerException��ָ���쳣
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Emp emp = empMapper(rs);//��������еĵ�ǰ��¼ת��ΪEmp����
				emps.add(emp);//��Emp������ӵ�������
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ȡ�����쳣��");
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return emps;
	}	
	/*
	 * ����Ա��������ѯԱ����Ϣ
	 */
	public List<Emp> findByEname(String ename){
		String sql = "select empno, ename, job, sal, comm, deptno, mgr, hiredate from emp where ename = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = empMapper(rs);
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯָ��������Ա����Ϣ�쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);			
		}
		return emps;		
	}
	/*
	 * ����1����ѯĳ�������й�����ߵ�Ա����Ϣ��
	 * select * from emp where sal = (select max(sal) from emp where deptno = ?)
	 * 
	 * ����2����ѯԱ����Ϣ�Լ�Ա�����ڵĲ�����Ϣ
	 * select ename, sal, job, deptno, dname, loc from emp e left join dept d
	 * on e.deptno = d.deptno
	 */
	
	/*
	 * ����1����ѯĳ�������й�����ߵ�Ա����Ϣ
	 */
	public List<Emp> findByDeptno(Integer deptno){
		String sql = "select * from emp where sal = (select Max(sal) from emp where deptno = ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = empMapper(rs);
				emps.add(emp);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��������߹���Ա����Ϣ�����쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);			
		}
		return emps;
	}
	/*
	 * ����2����ѯԱ����Ϣ���������ڵĲ�����Ϣ
	 */
	public List<Emp> findEmpWithDemp(){
		String sql = "select e.empno, e.ename, e.job, e.sal, e.comm, e.mgr, e.hiredate, d.deptno, d.dname, d.loc from emp e left join dept d on e.deptno = d.deptno";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Dept dept = DeptDao.deptMapper(rs);
				Emp emp = empMapper(rs);
				emp.setDept(dept);//��dept�������emp������
				emps.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ����������Ϣ��Ա����Ϣ�����쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return emps;
	}
	
	
}










