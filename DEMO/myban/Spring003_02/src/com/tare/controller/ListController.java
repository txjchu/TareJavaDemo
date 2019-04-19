package com.tare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tare.entity.City;

/**
 * 控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")
public class ListController {
	
	@RequestMapping("/city")
	public String listCity(ModelMap model){//参数ModelMap，用于以key-value形式储存数据
		List<City> listCity = new ArrayList<City>();
		listCity.add(new City("1", "北京"));
		listCity.add(new City("2", "上海"));
		listCity.add(new City("3", "广州"));
		listCity.add(new City("4", "深圳"));
		listCity.add(new City("5", "香港"));
		model.addAttribute("listCity", listCity);//将集合添加到ModelMap对象中
		return "listCity";
		
		
	}
}
