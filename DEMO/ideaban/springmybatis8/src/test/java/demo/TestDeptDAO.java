package demo;

import com.pc.demo.dao.MyBatisDeptDAO;
import com.pc.demo.entity.Dept;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 * 使用
 * @author: Peter
 * @date: 2020/12/16 22:40
 */
public class TestDeptDAO {

    ApplicationContext ac;

    @Before
    public void b(){
//        ac = new ClassPathXmlApplicationContext("classpath:WEB-INF/dispatcher-servlet.xml");
        ac = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
    }

    @Test
    public void t(){
        System.out.println(ac);
    }

    @Test
    public void t1(){

        /*
         * 笔记
         * 必须使: DeptMapper.xml 文件放在同目录下才可，如果放在 xml 下则会报错。Mapped Statements collection does not contain value for
         */
        MyBatisDeptDAO dao = ac.getBean("myBatisDeptDAO", MyBatisDeptDAO.class);

        System.out.println(dao);
        List<Dept> depts = dao.findAll();
        for(Dept dept : depts){
            System.out.println(dept);
        }
    }

    @Test
    public void t2(){
        MyBatisDeptDAO dao = ac.getBean("myBatisDeptDAO", MyBatisDeptDAO.class);
        System.out.println(dao.findById(20));
    }

    @Test
    public void t3(){
        Dept dept = new Dept();
        dept.setDeptno(60);
        dept.setDname("后勤");
        dept.setLoc("北京");
        MyBatisDeptDAO dao = ac.getBean("myBatisDeptDAO", MyBatisDeptDAO.class);
        dao.save(dept);
        System.out.println(dao.findById(60));
    }

    @Test
    public void t4(){
        MyBatisDeptDAO dao = ac.getBean("myBatisDeptDAO", MyBatisDeptDAO.class);
        Dept dept = dao.findById(60);
        dept.setLoc("上海");
        dao.update(dept);
        System.out.println(dao.findById(60));
        t1();
    }

    @Test
    public void t5(){
        MyBatisDeptDAO dao = ac.getBean("myBatisDeptDAO", MyBatisDeptDAO.class);
        dao.delete(60);
        t1();
    }
}
