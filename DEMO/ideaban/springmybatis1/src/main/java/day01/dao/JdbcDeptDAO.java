package day01.dao;

/**
 * @author: Peter
 * @date: 2020/12/1 19:56
 */
public class JdbcDeptDAO implements DeptDAO {
    public void save() {
        System.out.println(this.getClass().getName() +" : "+ "利用JDBC技术保存Dept信息。");
    }

    public void update() {
        System.out.println(this.getClass().getName() +" : "+ "利用JDBC技术更新Dept信息");
    }

    public void delete() {
        System.out.println(this.getClass().getName() +" : "+ "利用JDBC技术删除Dept记录");
    }
}
