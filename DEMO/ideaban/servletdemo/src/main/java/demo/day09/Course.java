package demo.day09;

/**
 * 实体类：课程类
 *
 * 练习 EL 表达式访问 Bean 的各个属性
 * @author: Peter
 * @date: 2020/11/17 15:19
 */
public class Course {
    private int courseId;
    private String courseName;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
