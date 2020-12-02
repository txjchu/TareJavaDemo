package day01;

import day01.service.DeptService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author: Peter
 * @date: 2020/12/1 16:47
 */
public class TestCase {

    ApplicationContext ctx = null ;


    @Before
    public void testBefore(){
        String cfg = "applicationContext.xml";
        ctx = new ClassPathXmlApplicationContext(cfg);
    }

    @After
    public void testAfter(){
//        ctx.close();
    }

    /**
     * 实例化 Spring 容器
     */
    @Test
    public void test1(){
        String cfg = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(cfg);
        System.out.println(ctx);
    }


    /**
     * 三种方式实例化 bean
     */
    @Test
    public void test2(){
        String cfg = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(cfg);

        // 通过构造器实例化 bean
        GregorianCalendar obj1 = (GregorianCalendar) ctx.getBean("obj1");
        System.out.println(this.getClass().getName() +" : "+ obj1);

        // 通过静态方法实例化
        Calendar obj2 = ctx.getBean("obj2", Calendar.class);
        System.out.println(this.getClass().getName() +" : "+ obj2);

        // 通过实例工厂方法实例化 bean
        Date obj4 = ctx.getBean("obj4", Date.class);
        System.out.println(this.getClass().getName() +" : "+ obj4);
    }

    @Test
    public void test3(){
        // obj5 的作用域为 singleton 单例
        Calendar c1 = ctx.getBean("obj5", GregorianCalendar.class);
        Calendar c2 = ctx.getBean("obj5", GregorianCalendar.class);
        System.out.println(this.getClass().getName() +" : "+ (c1 == c2)); // 比较引用地址是否相同，是否为同一个对象

        // obj6 的作用域为 prototype 原型
        Calendar c3 = (Calendar) ctx.getBean("obj6");
        Calendar c4 = (Calendar) ctx.getBean("obj6");
        System.out.println(this.getClass().getName() +" : "+ (c3 == c4));
    }

    @Test
    public void test4(){
        System.out.println("注意实例化与初始化的时刻------------------");
        ExampleBean bean = ctx.getBean("exampleBean", ExampleBean.class);
        bean.execute();

    }

    @Test
    public void test5(){
        Computer computer = ctx.getBean("computer", Computer.class);
        System.out.println(this.getClass().getName() +" : "+ computer.getMainboard());
        System.out.println(this.getClass().getName() +" : "+ computer.getHdd());
        System.out.println(this.getClass().getName() +" : "+ computer.getRam());
    }

    @Test
    public void test6(){
        Telephone telephone = ctx.getBean("telephone", Telephone.class);
        System.out.println(this.getClass().getName() +" : "+ telephone.getCpu());
        System.out.println(this.getClass().getName() +" : "+ telephone.getRam());
    }

    @Test
    public void test7(){
        Student student = ctx.getBean("student", Student.class);
        System.out.println(this.getClass().getName() +" : "+ student.getComputer());
        System.out.println(this.getClass().getName() +" : "+ student.getTelephone());
    }


    @Test
    public void test8(){
        DeptService service = ctx.getBean("deptService", DeptService.class);
        service.addDept();
        service.updateDept();
        service.deleteDept();
    }

    @Test
    public void test9(){

    }
}
