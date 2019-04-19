package com.tarena.demo.case03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * day03�İ���
 * @author Administrator
 *
 */
public class Case01 {
	
	//����1��JDBC���������
	@Test	
	public void test01(){
		transfer("A", "B", 500.3);
	}
	//ת�˷���
	public static void transfer(String from, String to, double amount){
		String sql1 = "update account set amount = amount - "+ amount +" where id = '"+ from +"'";
		String sql2 = "update account set amount = amount + "+ amount +" where id = '" + to +"'";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);//���ò��Զ��ύ����
			stmt.execute(sql1);//ִ��SQL
			stmt.execute(sql2);
			conn.commit();//�ύ����
			conn.setAutoCommit(true);//���û��Զ��ύ����
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException("����ع��쳣", e);
			}
			e.printStackTrace();
			throw new RuntimeException("���ݿ�����쳣��", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}
	
	//����2��JDBC����������SQL���
	@Test 	
	public void test02(){
		batchAdd();
	}
	//�������������ݿ���в������ݵ�SQL���ķ���
	public static void batchAdd(){
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);//�ر��Զ��ύ����
			int n = 0;
			for(int i = 0; i < 100; i ++){
				n = (int) (Math.random() * 100000);//������ɣ�0.0~1.0��*100000֮�����
				String sql = "insert into emp(empno, ename, sal) values(empseq.nextval, 'Ա��"+ i +"', "+ n +")";
				stmt.addBatch(sql);//��sql����ύ����������������
				if(i % 50 == 0){
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}
			stmt.executeBatch();//�����һ�������ܵ�SQL���ִ��
			stmt.clearBatch();//�������
			conn.commit();//�ύ����
			conn.setAutoCommit(true);//�����Զ��ύ����
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�������ݿ��쳣��", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}		
	}
	
	//����3�������������������룬��֤�������ݵĹ����ԡ�
	@Test	
	public void testAddEmp(){
		addEmp();
	}
	//������������
	public static void addEmp(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);//�ر��Զ��ύ����
			String sql = "insert into dept values(deptseq.nextval, ?, ?)";//�������в�������
			ps = conn.prepareStatement(sql, new String[]{"deptno"});//ִ��SQL
			ps.setString(1, "Research");
			ps.setString(2, "����");
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();//ͨ����䴦������ȡ�������ݣ�������������
			rs.next();//�ƶ�ָ��
			int deptno = rs.getInt(1);//��ȡ������е�ǰ��¼������
			String sql1 = "insert into emp(empno, ename, sal, deptno) values(empseq.nextval, ?, ?, ?)";
			ps = conn.prepareStatement(sql1);//ͨ�����Ӷ����ٴ������ݿ⽻�����������µĴ���������
			ps.setString(1, "����");
			ps.setDouble(2, 6666.7);
			ps.setInt(3, deptno);
			ps.executeUpdate();//ִ��sql
						
			conn.commit();//�ύ����
			conn.setAutoCommit(true);//�����Զ��ύ����
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�������ݿ��쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	//����4����ҳ��ѯ
	@Test
	public void testFindByPageOracle(){
		System.out.println("������ԣ�");
		findByPageOracle(14, 8);
	}
	//JDBC��Oracle���ݿ�ķ�ҳ��ѯ
	public void findByPageOracle(int page, int pageSize){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			//��ȷ�����ҳ��
			int maxPage = -1;
			String sql = "select count(*) from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();//��Ҫ�����ƶ�������е�ָ��
			int count = rs.getInt(1);//��ȡemp���м�¼����
			int n = count / pageSize;
			if(count % pageSize == 0 ){
				maxPage = n;
			} else {
				maxPage = n + 1;
			}
			System.out.println("emp���й���"+ count +"����¼������"+ maxPage +"ҳ��ÿҳ"+ pageSize +"����¼��");
			if(page > maxPage){//�������ҳ���������ҳ������ҳ���������ҳ��������ʾ���һҳ
				page = maxPage;
			}
			if(page < 1){//��pageС��1������ʾ��һҳ����
				page = 1;
			}
			int begin = (page - 1) * pageSize + 1;
			int end = page * pageSize;
			String sql1 = "select * from (select rownum rn, empno, ename, job, sal, deptno from (select * from emp order by empno)) where rn between "+ begin +"and "+ end ; 
			ps = conn.prepareStatement(sql1);
			rs = ps.executeQuery();
			System.out.println("empno\tename\tjob\tsal\tdeptno");
			while(rs.next()){//�ƶ������ָ��
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getDouble("sal"));
				emp.setDeptno(rs.getInt("deptno"));
				emps.add(emp);
			}
			for(Emp e : emps){
				System.out.println(e.getEmpno() +"\t"+ e.getEname() +"\t"+ e.getJob() +"\t"+ e.getSal() +"\t"+ e.getDeptno());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ݿ�����쳣", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}	
	
}













