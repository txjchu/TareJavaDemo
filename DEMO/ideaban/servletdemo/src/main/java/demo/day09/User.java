package demo.day09;

/**
 * 实体类：用户
 *
 * 练习 EL 表达式访问 Bean 属性。
 * @author: Peter
 * @date: 2020/11/17 15:22
 */
public class User {
    private String name;
    private int age;
    private Course course;
    private String[] interests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }
}
