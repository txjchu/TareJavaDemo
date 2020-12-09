package day02;

/**
 * @author: Peter
 * @date: 2020/12/6 22:26
 */
public class Cat extends Animal {
    public void sing() {
        System.out.println(this.getClass().getName() +": "+ "猫猫在唱歌！");
    }
}
