package ioc;
/**
 * ����ԭ��
 * 	�������ţ�����չ������
 *  �գ��رգ����޸Ĺرա�
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
