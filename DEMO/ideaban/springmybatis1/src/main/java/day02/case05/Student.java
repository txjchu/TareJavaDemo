package day02.case05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 练习在属性上使用注解方式注入 bean
 *
 * @author: Peter
 * @date: 2020/12/3 0:22
 */
@Component("studentDemo")
public class Student implements Serializable {

    @Autowired
    @Qualifier("computerDemo")
    private ComputerDemo computerDemo;

    public ComputerDemo getComputerDemo() {
        return computerDemo;
    }

    public void setComputerDemo(ComputerDemo computerDemo) {
        this.computerDemo = computerDemo;
    }
}
