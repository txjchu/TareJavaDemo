package day02;

import day02.case05.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Peter
 * @date: 2020/12/1 21:53
 */
public class TestCase {

    ApplicationContext ctx = null;
    String cfg = "applicationContext.xml";

    @Before
    public void testBefore(){
        ctx = new ClassPathXmlApplicationContext(cfg);

    }

    @Test
    public void test0(){
        Computer computer = ctx.getBean("computer2", Computer.class);
        System.out.println(this.getClass().getName() +" : "+ computer.toString());
    }

    @Test
    public void test1(){
        // 测试自动注入 配置式
        MessageBean bean = ctx.getBean("messageBean", MessageBean.class);
        bean.execute();
    }

    @Test
    public void test2(){
        // 测试使用注入表达式 #{}
        DemoBean bean = ctx.getBean("demo", DemoBean.class);
        bean.execute();
    }

    @Test
    public void test3(){
        // 测试 #{map.key} 的使用 可以直接使用，但是 key 不能有中文字符
        DemoBean bean = ctx.getBean("demo2", DemoBean.class);
        bean.execute();
    }

    @Test
    public void test4(){
        // 测试使用注解注册 bean
        ExampleBean bean = ctx.getBean("example", ExampleBean.class);
        System.out.println(this.getClass().getName() +": "+ bean);// 实例化一次，没有初始化和销毁
        bean.execute();
    }

    @Test
    public void test5(){
        // 测试 bean 的作用域
        ExampleBean bean1 = ctx.getBean("example", ExampleBean.class);
        ExampleBean bean2 = ctx.getBean("example", ExampleBean.class);
        System.out.println(bean1 == bean2); // true 结论：默认是单例模式，因此只进行一次实例化 bean ，且2个bean 指向的都是唯一的对象。
                                            // 当通过 @Scope 注解定义为 prototype 时，则 false ,每一次获取该 bean 都会进行一次实例化，表示会创建多个对象。
    }

    @Test
    public void test6(){
        AbstractApplicationContext act = (AbstractApplicationContext) ctx;
        ExampleBean bean = act.getBean("example", ExampleBean.class);
        bean.execute();
        act.close();
    }

    @Test
    public void test7(){
        Programmer programmer = ctx.getBean("programmer", Programmer.class);
        System.out.println(programmer);
        System.out.println(programmer.getComputer());
    }

    // 在setter 方法上使用 @Autowried 注解注入属性
    @Test
    public void test8(){
        Teacher teacher = ctx.getBean("teacher", Teacher.class);
        System.out.println(teacher);
        System.out.println(teacher.getComputerDemo());
    }

    // 在属性上使用注解方式注入 bean
    @Test
    public void test9(){
        // 如果在 applicationContext.xml 中已经配置了相同 id 的bean 则会报 BeanNotOfRequiredTypeException ,
        // Spring 会优先注入在 xml 中配置的bean
        // 因此需要为另一个 bean 重新指定自定义 id
        Student student = ctx.getBean("studentDemo", day02.case05.Student.class);
        System.out.println(student);
        System.out.println(student.getComputerDemo());
    }


    @Test
    public void test10(){
        // 练习使用 @Resource(name="") 注解注入 bean
        Manager manager = ctx.getBean("manager", Manager.class);
        System.out.println(manager);
        System.out.println(manager.getComputerDemo());
    }


    @Test
    public void test11(){
        // 练习在属性上使用 @Resource 方式注入 bean
        Salesman salesman = ctx.getBean("salesman", Salesman.class);
        System.out.println(salesman);
        System.out.println(salesman.getComputerDemo());
    }

    @Test
    public void test12(){
        // 练习使用注解表达式注入数据
        DBean dBean = ctx.getBean("DBean", DBean.class); // 注意该 bean 的 id
        System.out.println(dBean);
    }
}
