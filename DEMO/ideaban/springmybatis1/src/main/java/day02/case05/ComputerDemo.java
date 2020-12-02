package day02.case05;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 使用注解的方式声明 bean
 * @author: Peter
 * @date: 2020/12/2 21:00
 */
@Component
public class ComputerDemo implements Serializable {

    private String mainboard;   // 主板
    private String hdd;         // 硬盘
    private String ram;         // 内存

    @Override
    public String toString() {
        return "Computer{" +
                "mainboard='" + mainboard + '\'' +
                ", hdd='" + hdd + '\'' +
                ", ram='" + ram + '\'' +
                '}';
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
