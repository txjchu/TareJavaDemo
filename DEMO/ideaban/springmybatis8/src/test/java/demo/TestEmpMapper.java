package demo;

import com.pc.demo.dao.DeptMapper;
import com.pc.demo.dao.EmpMapper;
import com.pc.demo.entity.Dept;
import com.pc.demo.entity.Emp;
import com.pc.demo.service.EmpService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 笔记
 *
 * @author: Peter
 * @date: 2020/12/16 20:43
 */
public class TestEmpMapper {

    ApplicationContext ac ;

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("WEB-INF/dispatcher-servlet.xml");
    }

    @Test
    public void t(){
        System.out.println(ac);
    }

    @Test
    public void t1(){
        EmpMapper mapper = (EmpMapper) ac.getBean("empMapper", EmpMapper.class);
        List<Emp> emps = mapper.findAll();
        for(Emp emp : emps){
            System.out.println(emp);
        }
    }

    @Test
    public void t2(){
        DeptMapper mapper ;
//        mapper = ac.getBean("deptMapper", DeptMapper.class);
        mapper = (DeptMapper) ac.getBean("deptMapper");
        List<Dept> depts = mapper.findAll();
        for(Dept dept : depts){
            System.out.println(dept);
        }
    }

    @Test
    public void t3(){  // No qualifying bean of type 'com.pc.demo.dao.EmpMapper 放开  <property name="annotationClass" value="com.pc.demo.annotation.MyBatisMapper"/>  时提示
        EmpMapper mapper = ac.getBean("empMapper", EmpMapper.class);
        List<Emp> emps = mapper.findAll();
        for(Emp emp : emps){
            System.out.println(emp);
        }
    }

    @Test
    public void t4(){
        EmpService service = ac.getBean("empService", EmpService.class);
        List<Emp> emps = service.findAll();
        for(Emp emp : emps){
            System.out.println(emp);
        }
    }

}

