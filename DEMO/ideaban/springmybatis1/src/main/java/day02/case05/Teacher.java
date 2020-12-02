package day02.case05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 练习使用注解方式声明bean
 * @author: Peter
 * @date: 2020/12/3 0:17
 */
@Component
public class Teacher implements Serializable {

    private ComputerDemo computerDemo;


    public ComputerDemo getComputerDemo() {
        return computerDemo;
    }

    @Autowired      // 在 setter 方法上使用注解方式注入属性
    public void setComputerDemo(@Qualifier("computerDemo") ComputerDemo computerDemo) {
        this.computerDemo = computerDemo;
    }
}
