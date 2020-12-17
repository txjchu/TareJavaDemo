package com.pc.demo.controller;

import com.pc.demo.entity.Dept;
import com.pc.demo.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/17 23:02
 */
@Controller
@RequestMapping(value = "/demo/dept")
public class DeptController implements Serializable {

    @Resource
    private DeptService service;

    @RequestMapping(value = "list.do")
    public String list(ModelMap modelMap){
        List<Dept> depts = service.findAll();
        modelMap.addAttribute("depts", depts);
        return "main/dept_list";
    }
}
