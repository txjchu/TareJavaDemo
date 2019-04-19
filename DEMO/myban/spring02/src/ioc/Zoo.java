package ioc;
/**
 * 开闭原则：
 * 	开：开发，对扩展开发
 *  闭：关闭，对修改关闭
 * @author Administrator
 *
 */
public class Zoo {
	private Animal animal;
	public void perform(){//----perform表演执行
		animal.sing();
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
		
}
