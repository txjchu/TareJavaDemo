package com.tare.empmgr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tare.empmgr.entity.Emp;

/**
 * ������������
 * ��ʾspring��ajax��֧�֣��Լ�ʹ��json��������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/json")
public class JsonController {
	
	/*
	 * @ResponseBodyע�⣺�����ǽ���Ӧ����ת��Ϊjson��ʽ���ַ�����Ӧ����������Ӧ������
	 */
	@RequestMapping("/test1.do")
	@ResponseBody
	public boolean test1(){	//��Ӧ�������ֱ����һ��json�ַ�����
		return true;
	}
	@RequestMapping("/test2.do")
	@ResponseBody
	public Map<String, Object> test2(){		//����Map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 12);
		map.put("name", "����");
		return map;
	}
	@RequestMapping("/test3.do")
	@ResponseBody
	public List<String> test3(){		//���ؼ���
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		return list;		//���յ����ǣ�["aaa","bbb","ccc"]
	}
	
	@RequestMapping("/test4.do")
	@ResponseBody
	public Emp test4(){			//���ض���
		Emp emp = new Emp();
		emp.setEmpno(133);
		emp.setEname("����");
		emp.setJob("����Ա");
		return emp;				//���յ����ǣ�{"empno":133,"ename":"����","job":"����Ա","sal":null,"comm":null,"mgr":null,"deptno":null,"hiredate":null}
		
	}
	
	@RequestMapping("/test5.do")
	@ResponseBody
	public List<Emp> test5(){		//���ض��󼯺�
		List<Emp> emps = new ArrayList<Emp>();
		Emp e1 = new Emp();
        e1.setEmpno(1);
        e1.setEname("aaa");
        e1.setJob("aaa");
        e1.setMgr(1);
        e1.setSal(10000.0);
        e1.setDeptno(30);
        emps.add(e1);
        
        Emp e2 = new Emp();
        e2.setEmpno(1);
        e2.setEname("bbb");
        e2.setJob("bbb");
        e2.setMgr(1);
        e2.setSal(20000.0);
        e2.setDeptno(30);
        emps.add(e2);
        
        Emp e3 = new Emp();
        e3.setEmpno(1);
        e3.setEname("ccc");
        e3.setJob("ccc");
        e3.setMgr(1);
        e3.setSal(30000.0);
        e3.setDeptno(30);
        emps.add(e3);
        
        return emps;			
        	/*
        	 * ���յ����ǣ�
        	 * [
				  {
				    "empno": 1,
				    "ename": "aaa",
				    "job": "aaa",
				    "sal": 10000,
				    "comm": null,
				    "mgr": 1,
				    "deptno": 30,
				    "hiredate": null
				  },
				  {
				    "empno": 1,
				    "ename": "bbb",
				    "job": "bbb",
				    "sal": 20000,
				    "comm": null,
				    "mgr": 1,
				    "deptno": 30,
				    "hiredate": null
				  },
				  {
				    "empno": 1,
				    "ename": "ccc",
				    "job": "ccc",
				    "sal": 30000,
				    "comm": null,
				    "mgr": 1,
				    "deptno": 30,
				    "hiredate": null
				  }
				]
        	 */
	}
}
