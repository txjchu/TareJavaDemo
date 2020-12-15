package com.pc.controller;

import com.pc.entity.Emp;
import com.pc.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Emp 的控制器组件
 * @author: Peter
 * @date: 2020/12/13 1:24
 */
@Controller
@RequestMapping("/emp")
public class EmpController implements Serializable {

    @Resource
    private EmpService empService;

    @RequestMapping("/list.do")
    public String list(ModelMap modelMap){
        List<Emp> emps = empService.findAll();
        modelMap.addAttribute("emps", emps);
        return "emp/emp_list";
    }

    @RequestMapping("/toUpdate.do")
    public String toUpdate(@RequestParam("empno")String empno, Model model){
        Emp emp = empService.findById(Integer.parseInt(empno));
        model.addAttribute("emp", emp);
        return "emp/emp_update";
    }

    @RequestMapping("/update.do")
    public String updateEmp(Emp emp){
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + emp.toString());
        empService.updateEmp(emp);
        return "redirect:list.do";
    }


    /**
     * 笔记
     * @ModelAttribute 注解用在 Controller 方法参数前，或 Bean 属性方法上。
     * @ModelAttribute 会利用 HttpServletRequest 的 Attribute 将数据传递到 JSP 页面。
     * @return
     */
    @ModelAttribute(value = "deptMap")
    public Map<String, Object> getAllDept(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("10", "ACCOUNTING");
        map.put("20", "RESEARCH");
        map.put("30", "SALES");
        map.put("40", "OPERATIONS");
        return map;
    }
}
