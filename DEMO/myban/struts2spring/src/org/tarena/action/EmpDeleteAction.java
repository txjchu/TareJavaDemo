package org.tarena.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.tarena.entity.NoteResult;
import org.tarena.service.EmpService;

@Controller
public class EmpDeleteAction {
	
	//input
	private int no;
	//output
	private NoteResult result;
	
	@Resource
	private EmpService empService;
	
	public String execute(){
		result = empService.deleteEmp(no);
		return "success";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public NoteResult getResult() {
		return result;
	}

	public void setResult(NoteResult result) {
		this.result = result;
	}
}
