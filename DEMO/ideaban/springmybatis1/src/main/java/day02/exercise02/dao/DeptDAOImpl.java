package day02.exercise02.dao;

import org.springframework.stereotype.Repository;

/**
 * 练习使用 注解 方式
 * @author: Peter
 * @date: 2020/12/3 0:59
 */
@Repository     // @Repository 注解表示持久层
public class DeptDAOImpl implements IDeptDAO {

    public void add() {
        System.out.println(this.getClass().getName() +": "+ "使用JDBC技术进行 add 记录。");
    }

    public void delete() {
        System.out.println(this.getClass().getName() +": "+ "使用JDBC技术进行 delete 记录。");
    }

    public void update() {
        System.out.println(this.getClass().getName() +": "+ "使用JDBC技术进行 update 记录。");
    }
}
