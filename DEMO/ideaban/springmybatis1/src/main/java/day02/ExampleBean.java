package day02;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

/**
 * 练习使用注解注册 bean
 * @author: Peter
 * @date: 2020/12/2 20:35
 */
@Component("example")    // 可以在括号中自定义bean的id，如果不自定义则使用首字母小写的类名作为 bean 的id
//@Scope("prototype")    // 定义 bean 的作用域，默认是单例，定义为 prototype 原型，则表示每一次获取该 bean 都会创建1个新的对象实例。
@Scope("singleton")
public class ExampleBean implements Serializable {

    public ExampleBean(){
        System.out.println(this.getClass().getName() +" : "+ "实例化ExampleBean.");
    }

    @PostConstruct      // 用于指定初始化方法
    public void init(){
        System.out.println(this.getClass().getName() +": "+ "初始化ExampleBean.");
    }

    @PreDestroy     // 用于指定销毁方法
    public void destroy(){
        System.out.println(this.getClass().getName() +": "+ "销毁ExampleBean.");
    }

    public void execute(){
        System.out.println(this.getClass().getName() +": "+ "执行 execute 方法");
    }
}
