package com.tare.netctoss.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ICostDAO;
import com.tare.netctoss.entity.Cost;

/**
 * 请求Cost列表页面的Action
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")			//指定为多例
public class FindCostAction {
	
	@Resource
	private ICostDAO costDao;
	
	//input
	private int page = 1;//默认显示首页
	private int pageSize;//每页记录数
	
	//output
	private List<Cost> costs;
	private int totalPage;
	
	public String load(){
		try {
			costs = costDao.findByPage(page, pageSize);
			totalPage = costDao.findTotalPage(pageSize);
			System.out.println("-->FindCostAction:"+ costs);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
