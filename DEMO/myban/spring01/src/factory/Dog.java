package factory;

import java.io.Serializable;

import factory.Animal;

/**
 * 
 * @author Administrator
 *
 */
public class Dog extends Animal implements Serializable{	//----�̳����л��ӿ�
	public Dog(){
		System.out.println("������һֻ��");
	}
	public void cry(){
		System.out.println("������~~~");
		
	}
}
