package day02.case05;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 练习 @Resource 注解在 setter 方法或属性上注入 bean
 * @author: Peter
 * @date: 2020/12/3 0:32
 */
@Component
public class Manager implements Serializable {

    private ComputerDemo computerDemo;

    public ComputerDemo getComputerDemo() {
        return computerDemo;
    }

    @Resource(name = "computerDemo")    // 可以在 setter 方法上使用 @Resource(name="") 注解注入bean，若被注入的bean 是单例，则可以省略 name=""
    public void setComputerDemo(ComputerDemo computerDemo) {
        this.computerDemo = computerDemo;
    }
}
