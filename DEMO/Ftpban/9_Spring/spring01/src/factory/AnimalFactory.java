package factory;
/**
 * 简单工厂类，依据客户端的要求，返回
 * 各种产品。
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
