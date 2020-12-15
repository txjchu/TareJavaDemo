package com.pc.entity;

import java.io.Serializable;

/**
 * 部门类
 * @author: Peter
 * @date: 2020/12/16 5:13
 */
public class Dept implements Serializable {


    private Integer id; // 注意表中字段与实体类属性名不一致的问题 column: deptno
    private String name;    // 同上    column: dname
    private String loc;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
