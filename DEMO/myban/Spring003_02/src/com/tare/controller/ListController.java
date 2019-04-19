package com.tare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tare.entity.City;

/**
 * ������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")
public class ListController {
	
	@RequestMapping("/city")
	public String listCity(ModelMap model){//����ModelMap��������key-value��ʽ��������
		List<City> listCity = new ArrayList<City>();
		listCity.add(new City("1", "����"));
		listCity.add(new City("2", "�Ϻ�"));
		listCity.add(new City("3", "����"));
		listCity.add(new City("4", "����"));
		listCity.add(new City("5", "���"));
		model.addAttribute("listCity", listCity);//��������ӵ�ModelMap������
		return "listCity";
		
		
	}
}
