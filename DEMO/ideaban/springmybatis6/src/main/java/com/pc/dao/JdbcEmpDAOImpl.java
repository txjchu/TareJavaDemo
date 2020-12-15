package com.pc.dao;

import com.pc.entity.Emp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * IEmpDAO 的实现类
 * 使用 Spring+JDBC 技术，使用 JdbcTemplate 对象处理数据库的连接、关闭、SQL执操作
 * @author: Peter
 * @date: 2020/12/12 21:48
 */
@Repository
public class JdbcEmpDAOImpl implements IEmpDAO, Serializable {

    /**
     * 使用 @Resource 注解，通过 spring 容器自动注入 JdbcTemplate 对象
     */
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 查找所有记录
     * @return
     */
    public List<Emp> findAll()  {
        List<Emp> emps = jdbcTemplate.query("SELECT * FROM emp", new EmpRowMapper());
        return emps;
    }

    /**
     * 按照 ID 查找记录
     * @param id
     * @return
     */
    public Emp findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM emp WHERE empno = ?", new Object[]{id}, new EmpRowMapper());
    }

    /**
     * 根据 ename 查找记录
     * @param ename
     * @return
     */
    public Emp findByEname(String ename) {
        return jdbcTemplate.queryForObject("SELECT * FROM emp WHERE ename = ?", new Object[]{ename}, new EmpRowMapper());
    }

    /**
     * 插入新记录
     * @param emp
     */
    public void save(Emp emp) {
        // 定义 SQL 语句的参数数组
        Object[] objs = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno()};
        jdbcTemplate.update("INSERT INTO emp VALUES(NULL,?, ?, ?, ?, ?, ?, ?)", objs);
    }

    /**
     * 修改记录
     * @param emp
     */
    public void update(Emp emp) {
        Object[] objs = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno(), emp.getEmpno()};
        jdbcTemplate.update("UPDATE emp SET ename=?, job=?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? WHERE empno = ?", objs);
    }

    /**
     * 删除记录
     * @param id
     */
    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM emp WHERE empno = ?", id);
    }

    class EmpRowMapper implements RowMapper<Emp>{

        public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
            Emp e = new Emp();
            e.setEmpno(resultSet.getInt("empno"));
            e.setEname(resultSet.getString("ename"));
            e.setJob(resultSet.getString("job"));
            e.setMgr(resultSet.getInt("mgr"));
            e.setHiredate(resultSet.getDate("hiredate"));
            e.setSal(resultSet.getDouble("sal"));
            e.setComm(resultSet.getDouble("comm"));
            e.setDeptno(resultSet.getInt("deptno"));

            return e;
        }
    }
}
