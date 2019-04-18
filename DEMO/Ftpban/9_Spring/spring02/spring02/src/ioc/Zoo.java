package ioc;
/**
 * 开闭原则：
 * 	开：开放，对扩展开发。
 *  闭：关闭，对修改关闭。
 * @author Administrator
 *
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
