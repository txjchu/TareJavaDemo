package com.tarena.demo.case03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tare.dao.EmpDao;
import com.tarena.demo.entity.Dept;
import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * �κ���ϰ
 * @author Administrator
 *
 */
public class Exercise {
	
	//ϰ��1��JDBC�������
	@Test
	public void testUpdateByDeptno(){		
		updateByDeptno(10);
	}
	//�����Ÿ���Ա�����ʵķ���
	public static void updateByDeptno(int deptno){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//�ر��Զ��ύ����
			String sql1 = "update emp set sal = sal * 1.2 where job = ? and deptno = "+ deptno;
			ps = conn.prepareStatement(sql1);
			ps.setString(1, "ANALYST");
			ps.executeUpdate();
			String sql2 = "update emp set sal = sal * 1.3 where job = ? and deptno = "+ deptno;
			ps = conn.prepareStatement(sql2);
			ps.setString(1, "MANAGER");
			ps.executeUpdate();
			
			
			conn.commit();//�ύ����
			conn.setAutoCommit(true);//�ָ��Զ��ύ����
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {//����ع�
				e1.printStackTrace();
				System.out.println("�����ύʧ��");
			}
			e.printStackTrace();
			throw new RuntimeException("�����Ÿ���Ա�����ʷ����쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	//ϰ��2���������Ӽ�¼
	@Test	
	public void testBatchAdd(){
		batchAdd();
	}
	//�����ݿ�dept����������Ӽ�¼
	public static void batchAdd(){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//�ر��Զ�����
			stmt = conn.createStatement();
			for(int i = 0; i < 100; i ++){
				String sql = "insert into dept(deptno, dname) values(deptseq.nextval, '����"+ i +"')";
				stmt.addBatch(sql);
				if(i % 50 == 0){
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}
			stmt.executeBatch();
			stmt.clearBatch();
			conn.commit();//�ύ
			conn.setAutoCommit(true);//�ָ��Զ�����
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("���ݻع��쳣��");
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("�������ݿ��쳣��", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}

	//ϰ��3���������룬����������ϰ
	@Test
	public void testAddTeam(){
		List<Emp> emps = new ArrayList<Emp>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Emp emp1=new Emp();
        emp1.setEname("tom");
        emp1.setJob("manager");
        emp1.setMgr(7839);
        emp1.setSal(5000);
        emp1.setComm(300);
        emp1.setDeptno(30);
        
        Emp emp2=new Emp();
        emp2.setEname("marry");
        emp2.setJob("clerk");
        emp2.setMgr(1);
        emp2.setSal(2000);
        emp2.setDeptno(30);
        
        Emp emp3=new Emp();
        emp3.setEname("terry");
        emp3.setJob("salesman");
        emp3.setMgr(1);
        emp3.setSal(2500);
        emp3.setComm(200);
        emp3.setDeptno(30);
        
        Emp emp4=new Emp();
        emp4.setEname("jim");
        emp4.setJob("salesman");
        emp4.setMgr(1);
        try {
        	emp1.setHiredate(new java.sql.Date(sdf.parse("2014-05-01").getTime()));
        	emp2.setHiredate(new java.sql.Date(sdf.parse("2014-05-28").getTime()));
        	emp3.setHiredate(new java.sql.Date(sdf.parse("2014-05-29").getTime()));
			emp4.setHiredate(new java.sql.Date(sdf.parse("2014-05-26").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("����ת���쳣��");
		}
        emp4.setSal(2500);
        emp4.setComm(200);
        emp4.setDeptno(30);
        
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        emps.add(emp4);
        
        addTeam(emps);
	}
	//�����ݿ���emp����һ�����һ��Ա���ķ���--�������루��ϰ��������������
	public static void addTeam(List<Emp> emps){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) values(empseq.nextval, ?, ?, ?, TO_DATE(?, 'yyyy-mm-dd'), ?, ?, ?)";
			ps = conn.prepareStatement(sql, new String[]{"empno"});
			int mgr = 0;
			for(int i = 0; i < emps.size(); i++){
				Emp emp = emps.get(i);
				ps.setString(1, emp.getEname());
				ps.setString(2, emp.getJob());
				if(i == 0){
					ps.setInt(3, emp.getMgr());
				} else {
					ps.setInt(3, mgr);
				}
				ps.setString(4, emp.getHiredate().toString());//��Ϊ��SQL�����ʹ����TO_DATE��������ˣ�������Ҫ����String����
				ps.setDouble(5, emp.getSal());
				ps.setDouble(6, emp.getComm());
				ps.setInt(7, emp.getDeptno());
				ps.executeUpdate();//ִ��SQL
				if(i == 0){
					rs = ps.getGeneratedKeys();//��������������
					if(rs.next()){
						mgr = rs.getInt(1);//��ȡemps�е�һ��Ԫ�ص�empno������һ��Ԫ���Ǹ���Ա���Ĺ�����.						
					}
				}				
			}
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (IndexOutOfBoundsException e){
			System.out.println("�����±�Խ���쳣��");
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("������ع��쳣��");
			}			
			e.printStackTrace();
			throw new RuntimeException("�������ݿ��쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}				
	}

	//ϰ��4�����Զ�Dept���з�ҳ��ѯ�ķ���
	@Test
	public void testFindByPage(){
		findByPage(1, 16);
	}
	//��Dept���з�ҳ��ѯ�ķ���--��ϰJDBC�еķ�ҳ��ѯ
	public static void findByPage(int page, int pageSize){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql_total = "select count(*) from emp";
			int maxPage = 0;
			int total = -1;//���ڸ���������ҳ��
			ps = conn.prepareStatement(sql_total);
			rs = ps.executeQuery();
			if(rs.next()){
				total = rs.getInt(1);
			}
			//�������ҳ��
			int n = total % pageSize;
			if(n == 0){
				maxPage = total / pageSize;
			} else {
				maxPage = total / pageSize + 1;
			}
			if(page < 1){
				page = 1;//��������ҳ��С��1����ҳ������1������ʾ��ҳ��
			}else if(page > maxPage){
				page = maxPage;//��������ҳ���������ҳ��������ʾ���һҳ����ҳ���������ҳ��
			}
			int begin = (page - 1) * pageSize + 1;
			int end = page * pageSize;
			String sql = "select * from (select rownum rn, deptno, dname, loc from dept order by deptno) where rn between ? and ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			while(rs.next()){
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				System.out.println(dept);				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�������ݿ��쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	
	public static void main(String[] args) {
		
	}
	
}















