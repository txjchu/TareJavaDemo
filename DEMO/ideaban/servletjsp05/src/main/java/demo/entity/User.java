package demo.entity;

/**
 * day05 CASE 04
 * 实体类，用于描述用户 user 类与数据库中的 t_user 表中的字段一一对应
 * @author: Peter
 * @date: 2020/9/24 21:51
 */
public class User {
    private int id;
    private String userName;
    private String pwd;
    private String name;
    private String gender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return id +" "+ userName +" "+ pwd +" "+ name +" "+ gender;
    }
}
