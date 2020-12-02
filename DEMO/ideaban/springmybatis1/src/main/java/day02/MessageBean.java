package day02;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 练习注入
 * @author: Peter
 * @date: 2020/12/1 21:28
 */
public class MessageBean implements Serializable {
    // 基本值
    private String name;
    private int age;

    // bean 对象
    private Computer computer;

    // 集合
    private List<String> langs;
    private Set<String> cities;
    private Map<String, Object> score;
    private Properties props;


    public void execute(){
        System.out.println(this.getClass().getName() +" : "+ "基本值：");
        System.out.println(this.getClass().getName() +" : "+ name);
        System.out.println(this.getClass().getName() +" : "+ age);

        System.out.println(this.getClass().getName() +" : "+ "bean 对象：");
        if (computer != null){
            System.out.println(this.getClass().getName() +" : "+ computer.getMainboard());
            System.out.println(this.getClass().getName() +" : "+ computer.getHdd());
            System.out.println(this.getClass().getName() +" : "+ computer.getRam());
        }

        System.out.println(this.getClass().getName() +" : "+ "编程语言：");
        if(langs != null){
            for(String lang : langs){
                System.out.println(this.getClass().getName() +" : "+ lang);
            }
        }

        System.out.println(this.getClass().getName() +" : "+ "城市：");
        if(cities != null){
            for(String city : cities){
                System.out.println(this.getClass().getName() +" : "+ city);
            }
        }

        System.out.println(this.getClass().getName() +" : "+ "分数：");
        if(score != null){
            Set<String> set = score.keySet();
            for(String key : set){
                System.out.println(this.getClass().getName() +" : "+ key +":"+ score.get(key));
            }
        }

        System.out.println(this.getClass().getName() +" : "+ "参数：");
        if(props != null){
            Set<Object> set = props.keySet();
            for(Object key : set){
                System.out.println(this.getClass().getName() +" : "+ props.get(key.toString()));
            }
        }

    }

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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public List<String> getLangs() {
        return langs;
    }

    public void setLangs(List<String> langs) {
        this.langs = langs;
    }

    public Set<String> getCities() {
        return cities;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }

    public Map<String, Object> getScore() {
        return score;
    }

    public void setScore(Map<String, Object> score) {
        this.score = score;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
}
