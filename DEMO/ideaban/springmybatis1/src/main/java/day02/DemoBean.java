package day02;

import java.io.Serializable;

/**
 * 练习使用注入表达式来给 bean 注入属性
 * @author: Peter
 * @date: 2020/12/2 19:41
 */
public class DemoBean implements Serializable {
    private String name;
    private String lang;
    private String score;
    private int pageSize;

    @Override
    public String toString() {
        return "DemoBean{" +
                "name='" + name + '\'' +
                ", lang='" + lang + '\'' +
                ", score='" + score + '\'' +
                ", pageSize=" + pageSize +
                '}';
    }

    public void execute(){
        System.out.println(this.getClass().getName() +" : "+ this.getName());
        System.out.println(this.getClass().getName() +" : "+ this.getLang());
        System.out.println(this.getClass().getName() +" : "+ this.getScore());
        System.out.println(this.getClass().getName() +" : "+ this.getPageSize());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
