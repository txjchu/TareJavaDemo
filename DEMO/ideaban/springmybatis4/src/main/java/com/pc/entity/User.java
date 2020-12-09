package com.pc.entity;

import java.io.Serializable;

/**
 * 练习接收页面数据，向页面传递数据的实体类
 * @author: Peter
 * @date: 2020/12/8 1:03
 */
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String password;

    public User(){
        super();
    }
    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
