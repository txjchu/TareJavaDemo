package factory;
/**
 * 简单工厂类，一句客户端的要求，返回各种产品。
 * @author Administrator
 *
 */
public class AnimalFactory {
	public static Animal getAnimal(String type){
		if("dog".equals(type)){
			return new Dog();
		}else{
			return new Cat();
		}
	}
}
