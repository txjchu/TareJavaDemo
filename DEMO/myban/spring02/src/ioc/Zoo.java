package ioc;
/**
 * ����ԭ��
 * 	��������������չ����
 *  �գ��رգ����޸Ĺر�
 * @author Administrator
 *
 */
public class Zoo {
	private Animal animal;
	public void perform(){//----perform����ִ��
		animal.sing();
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
		
}
