package com.pc.netctoss.controller;

import com.pc.netctoss.entity.Cost;
import com.pc.netctoss.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/17 2:56
 */
@Controller
@RequestMapping(value = "/cost")
public class CostController implements Serializable {

    @Autowired
    private CostService costService;

    @RequestMapping(value = "/list.do")
    public String list(ModelMap map){
        List<Cost> costs = costService.findAll();
        map.addAttribute("costs", costs);
        System.out.println(costs);
        return "cost/cost_list";

    }









}
