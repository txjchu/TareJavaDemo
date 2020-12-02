package day01;

import java.io.Serializable;

/**
 * @author: Peter
 * @date: 2020/12/1 19:48
 */
public class Student implements Serializable {
    private String name;
    private Computer computer;
    private Telephone telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }
}
