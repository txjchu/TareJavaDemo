package factory;

public class peopleFactory {
	public static people getPeople(String type){
		if("teacher".equals(type)){
			return new teacher();
		}else{
			return new student();
		}
	}
}
