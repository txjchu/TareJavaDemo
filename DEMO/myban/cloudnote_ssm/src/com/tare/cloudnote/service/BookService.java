package com.tare.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tare.cloudnote.dao.NoteBookDAO;
import com.tare.cloudnote.entity.NoteBook;
import com.tare.cloudnote.util.NoteResult;

/**
 * 处理NoteBooks业务层组件接口
 * @author Administrator
 *
 */
		
public interface BookService {
	
	
	public NoteResult loadBooks(String userId);//按用户Id加载其所有的books
	
}
