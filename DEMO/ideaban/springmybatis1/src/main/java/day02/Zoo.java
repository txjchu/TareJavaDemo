package day02;

/**
 * 开闭原则
 * 对扩展开放，对修改关闭。
 * @author: Peter
 * @date: 2020/12/6 22:27
 */
public class Zoo {

    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void perform(){
        animal.sing();
    }
}
