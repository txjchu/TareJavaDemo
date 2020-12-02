package day02.case05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author: Peter
 * @date: 2020/12/2 21:02
 */
@Component
public class Programmer implements Serializable {

    private ComputerDemo computerDemo;

    @Autowired      // 自动注入注解，可以处理构造器注入和setter 注入，构造器注入推荐使用
    public Programmer(@Qualifier("computerDemo") ComputerDemo computerDemo ) {      // @Qualifier 同 @Autowired,但是写在参数前，声明需要注入的bean的id值
        this.computerDemo = computerDemo;
    }

    public ComputerDemo getComputer() {
        return computerDemo;
    }

    public void setComputer(ComputerDemo computerDemo) {
        this.computerDemo = computerDemo;
    }
}
