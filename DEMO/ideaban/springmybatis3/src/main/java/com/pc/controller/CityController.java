package com.pc.controller;

import com.pc.entity.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/12/7 18:49
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @RequestMapping("/list.do")
    public String listCity(ModelMap modelMap){
        List<City> cities = new ArrayList<City>();
        cities.add(new City("1001", "北京"));
        cities.add(new City("1002", "上海"));
        cities.add(new City("1003", "广州"));
        cities.add(new City("1004", "深圳"));
        cities.add(new City("1005", "杭州"));
        modelMap.addAttribute("cities", cities);

        return "jsp/listCity";
    }

}
