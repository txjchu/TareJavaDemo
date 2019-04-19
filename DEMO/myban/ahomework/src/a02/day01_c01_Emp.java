package a02;

public class day01_c01_Emp {
	public static void main(String[] args) {
		Emp emp1 = new Emp();
		emp1.name = "lili";
		emp1.age = 22;
		emp1.gender = '女';
		emp1.salary = 3000;
		//打印员工信息
		emp1.printInfo(emp1);
		
		//调整工资加20%
		emp1.salary *= 120.0/100.0;//注意数据类型的转换，不能直接写成120/100
		emp1.printInfo(emp1);
	}
}
