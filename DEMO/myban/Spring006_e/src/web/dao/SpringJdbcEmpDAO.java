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
 * EmpDAO的实现类，使用spring整合Jdbc技术
 * @author Administrator
 *
 */
@Repository			//持久层注解
public class SpringJdbcEmpDAO implements EmpDAO, Serializable {
	
	@Resource		//依赖注入
	private JdbcTemplate jdbcTemplate;
	
	public List<Emp> findAll() {	// infer 推论推断
		String sql = "select * from emp";
//		System.out.println(jdbcTemplate.getClass());//空指针异常	原因:在测试类中没有手动开启spring容器给其注入实例对象。
		return jdbcTemplate.query(sql, new EmpRowMapper());
	}

	public Emp findByNo(int empno) {
		String sql = "select * from emp where empno = ?";	//Object[]{}中的元素加上引号表示的是字符串，此处empno为int型参数不能加引号。
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
