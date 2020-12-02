package day01;

/**
 * @author: Peter
 * @date: 2020/12/1 19:12
 */
public class Telephone {
    private String cpu;
    private String ram;

    public Telephone(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
