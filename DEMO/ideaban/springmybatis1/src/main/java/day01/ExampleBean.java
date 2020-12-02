package day01;

import java.io.Serializable;

/**
 * @author: Peter
 * @date: 2020/12/1 18:36
 */
public class ExampleBean implements Serializable {
    public ExampleBean(){
        System.out.println(this.getClass().getName() +"实例化ExampleBean :"+ this);
    };

    public void init(){
        System.out.println(this.getClass().getName() +"初始化ExampleBean.");
    }

    public void destroy(){
        System.out.println(this.getClass().getName() +"销毁ExampleBean.");
    }

    public void execute(){
        System.out.println(this.getClass().getName() +"执行execute方法.");
    }
}
