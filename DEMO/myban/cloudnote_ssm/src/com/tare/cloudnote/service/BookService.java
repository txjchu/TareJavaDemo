package com.tare.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.cloudnote.dao.NoteBookDAO;
import com.tare.cloudnote.entity.NoteBook;
import com.tare.cloudnote.util.NoteResult;

/**
 * ����NoteBooksҵ�������ӿ�
 * @author Administrator
 *
 */
		
public interface BookService {
	
	
	public NoteResult loadBooks(String userId);//���û�Id���������е�books
	
}
