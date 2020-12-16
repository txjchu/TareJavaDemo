package com.pc.netctoss.controller;

import com.pc.netctoss.entity.Cost;
import com.pc.netctoss.service.CostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/11 22:13
 */
@Controller
@RequestMapping("/cost")
public class CostController implements Serializable {

    @Resource
    private CostService costService;

    @RequestMapping("/list.do")
    public String find(ModelMap modelMap){
        List<Cost> costs = costService.findAll();
        modelMap.addAttribute("costs", costs);
        return "cost/cost_list";
    }
}
