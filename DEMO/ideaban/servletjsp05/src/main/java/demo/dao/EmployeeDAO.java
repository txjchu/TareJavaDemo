package demo.dao;

import demo.utils.JDBCUtil;
import demo.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee 数据库操作对象
 * @author: Peter
 * @date: 2020/9/19 23:22
 */
public class EmployeeDAO {

    private static final String EXCEPTION_MSG = "连接数据库异常！";

    /**
     * 查询所有员工
     *
     */
    public List<Employee> findAll(){
        List<Employee> emps = new ArrayList<Employee>();
        // 创建连接
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM t_emp");
            rs = ps.executeQuery();
            while(rs.next()){
                // 将获取到的结果集从 rs 中封装成 employee 对象放入 list 中
                Employee emp = new Employee(rs.getInt("id"),rs.getString("name"), rs.getDouble("salary"), rs.getInt("age"));
                emps.add(emp);
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return emps;
    }

    /**
     * 根据 ID 查询员工信息
     *
     */
    public Employee findById(int id){
        Employee emp = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM t_emp WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"), rs.getInt("age"));
            }

        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return emp;
    }

    /**
     * 根据 ID 删除员工信息
     *
     */
    public void delete(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("DELETE FROM t_emp WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }


    /**
     * 增加一条员工记录
     * @param emp
     */
    public void save(Employee emp){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("INSERT INTO t_emp(id, name, salary, age) VALUES(NULL, ?, ?, ?)");
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getAge());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }

    }


    /**
     * 修改一条员工记录
     * @param emp
     */
    public void modify(Employee emp){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE t_emp SET name = ?, salary = ?, age = ? WHERE id = ?");
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getAge());
            ps.setInt(4, emp.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }





    public static void main(String[] args) {
        try {
            System.out.println(JDBCUtil.openConnection()); // jdbc:mysql://localhost:3306/lianxishujuku?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false, UserName=root@localhost, MySQL Connector/J
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
