package com.pc.demo.controller;

import com.pc.demo.entity.Dept;
import com.pc.demo.entity.Emp;
import com.pc.demo.service.DeptService;
import com.pc.demo.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/17 22:33
 */
@Controller
@RequestMapping(value = "/demo/emp")
public class EmpController implements Serializable {

    @Resource
    private EmpService service;

    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/list.do")
    public String list(ModelMap map){
        List<Emp> emps = service.findAll();
        map.addAttribute("emps", emps);
        return "main/emp_list";
    }

    @RequestMapping(value = "/toUpdate.do")
    public String toUpdate(@RequestParam(value = "id") Integer empno, ModelMap modelMap){
        Emp emp = service.findById(empno);
        modelMap.addAttribute("emp", emp);
        List<Dept> depts = deptService.findAll();
        modelMap.addAttribute("depts", depts);
        return "main/emp_update";
    }

    @RequestMapping(value = "/update.do")
    public String update( Emp emp){
        service.update(emp);
        return "redirect:list.do";
    }
}
