package com.tare.netctoss.test;
/**
 * ���Ծ�ƽ����ߵķ���
 * @author Administrator
 *
 */
public class TestAvg {

	public static double getAvg(Student[] students){
		double sum = 0;
		for(int i = 0; i < students.length; i++){
			sum += students[i].getHeight();
		}
		return sum / students.length;
	}
	
	public static void main(String[] args) {
//		double[] height = new double[]{1.87, 1.22, 1.55, 1.56, 1.74};
//		double avg = getAvg(height);
//		System.out.println(avg);
		
	}
	class Student{
		private String name;
		private double height;
		public Student(){
			
		}
		public Student(String name, double height){
			this.name = name;
			this.height = height;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getHeight() {
			return height;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		
	}
}
