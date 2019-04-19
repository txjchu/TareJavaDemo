package web.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 实体类Emp与数据库中记录的映射转换类
 * @author Administrator
 *
 */
public class EmpRowMapper implements RowMapper<Emp>{

	public Emp mapRow(ResultSet rs, int index) throws SQLException {
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setJob(rs.getString("job"));
		emp.setMgr(rs.getInt("mgr"));
		emp.setSal(rs.getDouble("sal"));
		emp.setComm(rs.getDouble("comm"));
		emp.setHiredate(rs.getDate("hiredate"));
		emp.setDeptno(rs.getInt("deptno"));
		return emp;
	}
	
	
}
