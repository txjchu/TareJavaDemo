package day01;

/**
 * setter 方式为 bean 注入值
 * @author: Peter
 * @date: 2020/12/1 19:05
 */
public class Computer {

    private String mainboard;   // 主板
    private String hdd;         // 硬盘
    private String ram;         // 内存

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
