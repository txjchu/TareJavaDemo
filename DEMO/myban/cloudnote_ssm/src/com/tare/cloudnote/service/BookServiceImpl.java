package com.tare.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tare.cloudnote.dao.NoteBookDAO;
import com.tare.cloudnote.entity.NoteBook;
import com.tare.cloudnote.util.NoteResult;

/**
 * BookService��ʵ����
 * @author Administrator
 *
 */
@Service
public class BookServiceImpl implements BookService{

	@Resource
	private NoteBookDAO noteBookDao;
	
	@Transactional(readOnly=true)	//ʹ��Spring������ع������ǲ�ѯ�г������쳣����ع���
	public NoteResult loadBooks(String userId) {
		NoteResult result = new NoteResult();
		List<NoteBook> books = noteBookDao.findByUserId(userId);
		result.setMsg("���سɹ���");
		result.setStatus(0);
		result.setData(books);//��books���뷵��������Ķ�����
		return result;
	}
	
	
}
