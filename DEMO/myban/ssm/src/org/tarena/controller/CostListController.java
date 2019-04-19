package org.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.entity.Cost;
import org.tarena.service.CostService;

@Controller
@RequestMapping("/cost")
public class CostListController {
	@Resource
	private CostService service;
	
	@RequestMapping("/list.do")
	@ResponseBody		//----����һ��JSON���������
	public List<Cost> execute(){
		return service.loadCosts();
	}
}
