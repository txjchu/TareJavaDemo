package factory;
/**
 * �򵥹����࣬һ��ͻ��˵�Ҫ�󣬷��ظ��ֲ�Ʒ��
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
