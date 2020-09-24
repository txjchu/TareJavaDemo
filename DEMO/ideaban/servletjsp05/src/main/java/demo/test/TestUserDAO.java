package demo.test;

import demo.dao.UserDAO;
import demo.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/9/24 22:16
 */
public class TestUserDAO {
    UserDAO dao = null;

    @Before
    public void before(){
        dao = new UserDAO();
    }

    @Test
    public void testFindByName(){
        try {
            User  user = dao.findByUserName("cat");
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById(){
        try {
            User user = dao.findById(1);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("jim");
        user.setPwd("123456");
        user.setName("吉姆");
        user.setGender("m");
        try {
            dao.save(user);
            User u = dao.findByUserName("jim");
            System.out.println(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll(){
        List<User> users;
        try {
            users = dao.findAll();
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
