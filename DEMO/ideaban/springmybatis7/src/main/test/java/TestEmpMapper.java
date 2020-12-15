import com.pc.dao.EmpMapper;
import com.pc.entity.Emp;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Peter
 * @date: 2020/12/16 2:50
 */
public class TestEmpMapper {

    EmpMapper dao;

    @Before
    public void before(){
        dao = new EmpMapper();

    }


    @Test
    public void test1(){
//        EmpMapper dao = new EmpMapper();
        List<Emp> emps = dao.findAll();
        for(Emp e : emps){
            System.out.println(e.toString());
        }
    }

    @Test
    public void test2(){
//        EmpMapper dao = new EmpMapper();
        Emp emp = dao.findById(7936);
        System.out.println(emp);
    }

    @Test
    public void test3(){
        Emp emp = new Emp();
        emp.setEname("李四");
        emp.setJob("SALESMAN");
        emp.setHiredate(new Date());
        emp.setSal(2323.23);
        emp.setComm(5566.56);
        emp.setDeptno(20);
        emp.setMgr(1111);
        emp.setEmpno(null);
//        EmpMapper dao = new EmpMapper();
        dao.save(emp);
        test1();
    }

    @Test
    public void test4(){
//        EmpMapper dao = new EmpMapper();
        List<Emp> emps = dao.findByName("李四");
        for(Emp emp : emps){
            System.out.println(emp);
        }
        System.out.println(emps.size() +":"+ emps.get(0));
    }

    @Test
    public void test5(){
        Emp emp = dao.findById(7938);
        emp.setEname("王五");
        dao.update(emp);
        test1();
    }

    @Test
    public void test6(){
        dao.delete(7938);
        test1();
    }

    @Test
    public void test7(){
        List<Map<String, Object>> maps = dao.findByDeptno(10);
        for(Map map : maps){
            System.out.println(map);
        }
        System.out.println("------------------------");
        for(Map map : maps){
            System.out.println("empno:"+ map.get("empno") +
                             ", ename:"+ map.get("ename") +
                             ", job:"+ map.get("job") +
                             ", mgr:"+ map.get("mgr") +
                             ", deptno:"+ map.get("deptno"));
        }
    }


}
