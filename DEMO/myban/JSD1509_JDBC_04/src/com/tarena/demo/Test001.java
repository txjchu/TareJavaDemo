package com.tarena.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.tarena.demo.entity.Emp;
import com.tarena.demo.util.JdbcUtil;

/**
 * ���Կɹ��������
 * @author Administrator
 *
 */
public class Test001 {
	
	@Test	//���Կɹ��������
	public void test01(){
		String sql = "select empno, ename, sal from emp";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> emps = new ArrayList<Emp>();
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//���ÿɹ���������������ɹ����������У�ֻ��
			rs = stmt.executeQuery(sql);
			
			//ָ�������
			rs.absolute(5);
			System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename"));
			//��ǰ����һ��
			rs.previous();
			System.out.println(rs.getInt("empno") +"\t"+ rs.getString("ename"));
						
/*			
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEname(rs.getString("ename"));
				emp.setEmpNo(rs.getInt("empno"));
				emp.setSal(rs.getDouble("sal"));
				emps.add(emp);
			}
*/			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���Է���1�쳣��", e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);			
		}
		for(Emp e : emps){
			System.out.println(e);
		}
	}
	
	@Test	//��ʾJDBC������
	public void test02(){
		int outId = 8820;
		int inId = 8815;
		double money = 1000;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			//1.�ȹر��Զ��ύ	�����Զ��ύ��ʽΪfalse
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			//2.ִ��SQL���	ת����ת��
			String outSql = "update emp set sal = sal - "+ money +" where empno = "+ outId;
			stmt.executeUpdate(outSql);
			String inSql = "update emp set sal = sal +"+ money +" where empno = "+ inId;
			stmt.executeUpdate(inSql);
			//3.�ύ����		
			conn.commit();
			
		} catch (SQLException e) {
			try {
				//�ع�	���ύʧ��
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("��ʾJDBC���������쳣��", e);
		} finally {
			//4.��ԭ�Զ��ύ����
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			JdbcUtil.close(null, stmt, conn);
		}
	}
	@Test	//��Ա����Ų�ѯԱ����Ϣ
	public void testFindByEmpno(){
		String sql = "select empno, ename, job, sal, comm from emp where empno = ?";
		Integer empno = 3002;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
				emp.setJob(rs.getString("job"));
				emp.setComm(rs.getDouble("comm"));
				System.out.println(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���Բ�ѯԱ����Ϣ�����쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
	}
	
	@Test	//���������������ݵķ���
	public void test03(){
//		insertByBatch();
		int[] empnos = new int[200];//�������鳤��100
		int empno = 3401;
		for(int i = 0; i < empnos.length; i++){//�����鸳ֵ
			empnos[i] = empno;
			empno ++;
		}
		System.out.println(Arrays.toString(empnos));
		deleteByBatch(empnos);
	}
	//��������ɾ�����
	public static void deleteByBatch(int[] empnos){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from emp where empno = ?";
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			int count = 0;
			for(int empno : empnos){
				ps.setInt(1, empno);
				ps.addBatch();
				count ++;
				if(count % (empnos.length / 5) == 0){//����1/5��empnoʱ��ִ��һ�Σ���ֹ�ڴ����
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			ps.clearParameters();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ɾ����䷽���쳣��", e);
		} finally {
			JdbcUtil.close(null, ps, conn);
		}
	}
	//��������������
	public static void insertByBatch(){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			int count = 300;
			for(int i = 0; i < count; i++){
				String sql = "insert into emp(empno, ename) values(empseq.nextval, 'Ա��"+ i % 100 +"')"; 
				stmt.addBatch(sql);
				if(i % 200 == 0){//��ֹOutOfMemory�ڴ����
					stmt.executeBatch();
					stmt.clearBatch();
				}
			}
			//�����200��ʱ
			stmt.executeBatch();
			stmt.clearBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�������������䷽���쳣��", e);
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}		
	}
	
	@Test	//��ʾJDBC�������ݿ���Ź��������������ʱ���������ݵĹ����ԡ�
	public void test04(){
		//1.���������SQL��ʹ�ø�������Ϊ����
		String sql1 = "insert into dept values(deptseq.nextval, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			//2.����stmtʱ���ڶ�������������GeneratedKeys������ȡ�������ֶ����б��������ַ������顣
			ps = conn.prepareStatement(sql1, new String[]{"deptno"});
			ps.setString(1, "������");
			ps.setString(2, "����");
			//3.ִ��SQL
			ps.executeUpdate();//��dept������Ӽ�¼
			//4.��ȡ����ֵ
			rs = ps.getGeneratedKeys();
			rs.next();//�ƶ��������ָ��
			int deptno = rs.getInt(1);//�������ǰ��¼�ĵ�һ�е�����
			String sql2 = "insert into emp(empno, ename, deptno) values (empseq.nextval, ?, ?)";
			//5.����ȡ��������ֵ����Ϊ������뵽���С�
			ps = conn.prepareStatement(sql2);//Ԥ����SQL
			ps.setString(1, "����");//��emp������Ӽ�¼
			ps.setInt(2, deptno);
			ps.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�����������ݷ����쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}		
	}
	
	/*
	 * ��ҳ��ѯ
	 * Oracle �з�ҳ��ѯʹ��Rownum
	 * MySQL��ʹ��
	 * Select empno, ename, job From emp Limit begin, pageSize; 
	 */
	@Test
	public void test05(){
		//emp���й���20����¼
		int maxPage = maxPage(6);
		System.out.println(maxPage);
		System.out.println(maxPage(5));
		System.out.println(maxPage(8));
		List<Emp> emps = new ArrayList<Emp>();
		emps = findByPage(4, 5);//����ҳ�����ڱ��з�ҳ�����ҳ���Ļ�����û���κμ�¼������ʾ��
		System.out.println("empno\tename\tsal");
		for(Emp e : emps){
			System.out.println(e.getEmpno() +"\t"+ e.getEname() +"\t"+ e.getSal() );
		}
		
		
	}
	public static List<Emp> findByPage(int page, int pageSize){
		String sql = "select * from (select rownum rn, empno, ename, sal from emp) where rn between ? and ?";
		int begin = (page - 1) * pageSize + 1;
		int end = page * pageSize;
		List<Emp> emps = new ArrayList<Emp>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getDouble("sal"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ҳ��ѯ�����쳣��", e);
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		return emps;
	}
	//�������ҳ��
	public static int maxPage(int pageSize){
		String sql = "select count(*) from emp";
		int maxPage = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();//-----------��Ҫ���ǵ���rs.next()�ƶ��������ָ��
			int count = rs.getInt(1);
			int n = count / pageSize; 
			if(count % pageSize == 0){
				maxPage = n;
			} else {
				maxPage = n + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ���ҳ���쳣", e);
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return maxPage;
		
	}


	@Test
	public void test(){
		System.out.println(tryCatch());
	}
	//try-catch-finally��������
	public static int tryCatch(){
		int b = 20;
		try {
			System.out.println("try block");
			return b += 80;
		} catch (Exception e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally block");
			if( b > 25){
				System.out.println("b > 25, b = "+ b);
			}
			b = 150;
		}
		return 2000;
		
	}

	
	
}













