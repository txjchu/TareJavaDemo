package org.tarena.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.dao.EmpDao;
import org.tarena.entity.NoteResult;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Resource
	private EmpDao empDao;
	
	@Override
	public NoteResult deleteEmp(int no) {
		// TODO Auto-generated method stub
		empDao.delete(no);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("ɾ���ɹ�");
		
		return result;
	}
	
}
