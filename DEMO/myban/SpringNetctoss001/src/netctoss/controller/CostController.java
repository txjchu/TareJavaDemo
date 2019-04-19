package netctoss.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import netctoss.entity.Cost;
import netctoss.service.CostService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * �ʷ��б�ģ��Ŀ��Ʋ�
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cost")
public class CostController implements Serializable{
	@Resource		//����ע��
	private CostService costService;
	
	//�����쳣
	@ExceptionHandler
	public String execute(HttpServletRequest req, Exception e) throws Exception{
		System.out.println("costController����һ���쳣��"+ e.getClass().toString());
		e.printStackTrace();//��ӡ����쳣���
		throw e;
	}
	
	@RequestMapping("/find.do")
	public String find(ModelMap model){
		List<Cost> list = costService.findAll();
		model.addAttribute("costs", list);
		return "cost/cost_list";
	}
}
