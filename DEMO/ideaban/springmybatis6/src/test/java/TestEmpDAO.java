import com.pc.dao.IEmpDAO;
import com.pc.entity.Emp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * 笔记：
 *
 * @author: Peter
 * @date: 2020/12/12 23:21
 */
public class TestEmpDAO {

    ApplicationContext ac ;
    IEmpDAO dao ;
    String str = this.getClass().getName() +": ";

    @Before
    public void before(){
//        ac = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");  // 这样是读取不到 WEB-INF 下的 xml 文件的
        ac = new FileSystemXmlApplicationContext("web/WEB-INF/dispatcher-servlet.xml");
        dao = ac.getBean("jdbcEmpDAOImpl", IEmpDAO.class);
    }

    @Test
    public void testFindAll() {
//        IEmpDAO dao = ac.getBean("jdbcEmpDAOImpl", IEmpDAO.class);
        List<Emp> emps = dao.findAll();
        for(Emp e : emps){
//            System.out.println(getClass().getName() +": "+ Thread.currentThread().getStackTrace()[1].getMethodName() +": "+ e.toString());
            System.out.println(str + Thread.currentThread().getStackTrace()[1].getMethodName() +": "+ e.toString());
        }
    }


    @Test
    public void testFindById(){
        Emp emp = dao.findById(7839);
        System.out.println(str + Thread.currentThread().getStackTrace()[1].getMethodName() +": "+ emp.toString());
    }

    @Test
    public void testSave(){
        Emp emp = new Emp();
        emp.setEname("张三");
        emp.setJob("MANAGER");
        emp.setMgr(7521);
        emp.setHiredate(new Date());
        emp.setSal(4567.77);
        emp.setComm(2222.22);
        emp.setDeptno(10);
        dao.save(emp);
        testFindAll();
    }

    @Test
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setEmpno(7935); // testSave() 方法保存的记录的 ID
        emp.setEname("李四");
        dao.update(emp);    // update() 方法会因为 emp 的其他属性为空，update 后将之前的记录中的其他字段的数据更新为空或初始值。
        testFindAll();
    }

    @Test
    public void testUpdate2(){
        Emp emp = dao.findByEname("张三");
        emp.setComm(3333.33);
        dao.update(emp);
        testFindByEname();
    }

    @Test
    public void testFindByEname(){
        Emp emp = dao.findByEname("张三");
        System.out.println(str + Thread.currentThread().getStackTrace()[1].getMethodName() + emp.toString());
    }

    @Test
    public void testDelete(){
//        dao.delete(7935);
        dao.delete(dao.findByEname("张三").getDeptno());
        testFindAll();
    }
}
