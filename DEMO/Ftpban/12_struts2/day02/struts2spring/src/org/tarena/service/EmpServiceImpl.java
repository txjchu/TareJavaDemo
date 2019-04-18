package org.tarena.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.dao.EmpDao;
import org.tarena.entity.NoteResult;

@Service
public class EmpServiceImpl implements EmpService{
	@Resource
	private EmpDao empDao;
	
	public NoteResult deleteEmp(int no) {
		empDao.delete(no);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("É¾³ý³É¹¦");
		return result;
	}

}
