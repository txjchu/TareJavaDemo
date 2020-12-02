package day02.case05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 练习使用 Spring 表达式注入 @Value(#{})
 * @author: Peter
 * @date: 2020/12/3 0:43
 */
@Component      // 该类使用 @Component 注解后，被声明的bean 的 id 为 DBean ，而不是 dBean
public class DBean implements Serializable {

    private String name;
    private String score;

    @Value("#{const.PAGE_SIZE}")
    private int pageSize;


    @Override
    public String toString() {
        return "DBean{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getPageSize() {
        return pageSize;
    }

//    @Value(value = "#{const.PAGE_SIZE}") // 可以用在属性上或者 setter 方法上
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
