package day02;

/**
 * @author: Peter
 * @date: 2020/12/6 22:25
 */
public class Doge extends Animal {
    public void sing() {
        System.out.println(this.getClass().getName() +": "+ "狗狗在唱歌！");
    }
}
