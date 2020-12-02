package day02.case05;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 练习在属性上使用 @Resource(name="") 注解的方式注入bean
 * @author: Peter
 * @date: 2020/12/3 0:36
 */
@Component
public class Salesman {

    @Resource(name = "computerDemo")
    private ComputerDemo computerDemo;


    public ComputerDemo getComputerDemo() {
        return computerDemo;
    }

    public void setComputerDemo(ComputerDemo computerDemo) {
        this.computerDemo = computerDemo;
    }
}
