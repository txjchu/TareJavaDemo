package demo.entity;

/**
 * 整合 Servlet
 * 实体类：员工属性与 t_emp 表中的字段相对应
 * @author: Peter
 * @date: 2020/9/19 23:15
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;

    public Employee(){
        super();
    }
    public Employee(int id, String name, double salary, int age){
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return id +" "+ name +" "+ salary +" "+ age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
