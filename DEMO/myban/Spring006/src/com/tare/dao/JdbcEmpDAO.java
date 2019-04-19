package com.tare.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tare.entity.Emp;

/**
 * EmpDAO��ʵ���࣬����Spring�������Jdbc����
 * @author Administrator
 *
 */
@Repository
public class JdbcEmpDAO implements EmpDAO{

	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private DataSource dataSource;
	
	public void delete(int id) {
		String sql = "delete emp where empno = ?";
		jdbcTemplate.update(sql, id);
		
	}

	public List<Emp> findAll() {
		String sql = "select * from emp";
		System.out.println(dataSource.getClass());
//		System.out.println(jdbcTemplate.getClass());
		return jdbcTemplate.query(sql, new EmpRowMapper());
	}

	public Emp findById(int id) {
		String sql = "select * from emp where empno = ?";
		//��������ֵΪһ��object���󣬱������е�sql����ѯ����Ϊһ����¼���÷����Ὣ�ü�¼ת��Ϊһ�������Emp����󷵻ء�
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmpRowMapper());
	}

	public void save(Emp emp) {
		String sql = "insert into emp values(empseq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
							emp.getSal(), emp.getComm(), emp.getDeptno()};
		jdbcTemplate.update(sql, params);//ִ�в������		
	}

	public void update(Emp emp) {
		String sql = "update emp set ename = ?, job = ?, mgr = ?, hiredate = ?, sal= ?, comm = ?, deptno = ? where empno = ?";
		Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(),
							emp.getComm(), emp.getDeptno(), emp.getEmpno()};
		jdbcTemplate.update(sql, params);
	}
	
	//����ѯ�ļ�¼ת��Ϊʵ����
	class EmpRowMapper implements RowMapper<Emp>{
		
		public Emp mapRow(ResultSet rs, int index) throws SQLException {
			Emp e = new Emp();
			e.setEmpno(rs.getInt("empno"));
			e.setEname(rs.getString("ename"));
			e.setJob(rs.getString("job"));
			e.setMgr(rs.getInt("mgr"));
			e.setHiredate(rs.getDate("hiredate"));
			e.setSal(rs.getDouble("sal"));
			e.setComm(rs.getDouble("comm"));
			e.setDeptno(rs.getInt("deptno"));
			
			return e;
		}
		
		
	}


	
	
}
