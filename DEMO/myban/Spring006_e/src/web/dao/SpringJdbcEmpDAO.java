package web.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import web.entity.Emp;
import web.entity.EmpRowMapper;
/**
 * EmpDAO��ʵ���࣬ʹ��spring����Jdbc����
 * @author Administrator
 *
 */
@Repository			//�־ò�ע��
public class SpringJdbcEmpDAO implements EmpDAO, Serializable {
	
	@Resource		//����ע��
	private JdbcTemplate jdbcTemplate;
	
	public List<Emp> findAll() {	// infer �����ƶ�
		String sql = "select * from emp";
//		System.out.println(jdbcTemplate.getClass());//��ָ���쳣	ԭ��:�ڲ�������û���ֶ�����spring��������ע��ʵ������
		return jdbcTemplate.query(sql, new EmpRowMapper());
	}

	public Emp findByNo(int empno) {
		String sql = "select * from emp where empno = ?";	//Object[]{}�е�Ԫ�ؼ������ű�ʾ�����ַ������˴�empnoΪint�Ͳ������ܼ����š�
		return jdbcTemplate.queryForObject(sql, new Object[]{empno}, new EmpRowMapper());
	}

	public void update(Emp emp) {
		String sql = "update emp set ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? where empno = ?";
		System.out.println(emp.getEname() +":"+ emp.getEname().length());
		Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
							emp.getSal(), emp.getComm(), emp.getDeptno(), emp.getEmpno()};
		jdbcTemplate.update(sql, params);		
	}

	public void delete(int empno) {
		String sql = "delete emp where empno = ?";
		jdbcTemplate.update(sql, empno);
		
	}

	public void save(Emp emp) {
		String sql = "insert into emp values(empseq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(),
							emp.getSal(), emp.getComm(), emp.getDeptno()};
		jdbcTemplate.update(sql, params);
	}
	
	
}
