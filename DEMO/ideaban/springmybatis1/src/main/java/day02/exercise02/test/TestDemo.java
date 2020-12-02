package day02.exercise02.test;

import day02.exercise02.service.DeptService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Peter
 * @date: 2020/12/3 1:05
 */
public class TestDemo {

    ApplicationContext ctx = null;
    String cfg = "applicationContext.xml";

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext(cfg);
    }

    @Test
    public void test1(){
        DeptService service = ctx.getBean("deptServiceDay02", DeptService.class);
        service.addDept();
        service.updateDept();
        service.deleteDept();
    }
}
