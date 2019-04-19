package springJDBC.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springJDBC.service.DeptService;



public class testCase {
//	@Test
//	public void test1(){
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DeptService dd1 = ac.getBean("deptService",DeptService.class);
//		dd1.addDept();
//		dd1.deleteDept();
//		dd1.updateDept();
//	}
    public static void main(String[] args) throws Exception {
        String conf = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
        DeptService service = ac.getBean("deptService", DeptService.class);
        service.addDept();
        service.updateDept();
        service.deleteDept();
    }
}
