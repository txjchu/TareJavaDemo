package a02;

public class day01_c01_Emp {
	public static void main(String[] args) {
		Emp emp1 = new Emp();
		emp1.name = "lili";
		emp1.age = 22;
		emp1.gender = 'Ů';
		emp1.salary = 3000;
		//��ӡԱ����Ϣ
		emp1.printInfo(emp1);
		
		//�������ʼ�20%
		emp1.salary *= 120.0/100.0;//ע���������͵�ת��������ֱ��д��120/100
		emp1.printInfo(emp1);
	}
}
