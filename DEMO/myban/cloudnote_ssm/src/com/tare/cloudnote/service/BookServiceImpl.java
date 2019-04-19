package com.tare.cloudnote.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tare.cloudnote.dao.NoteBookDAO;
import com.tare.cloudnote.entity.NoteBook;
import com.tare.cloudnote.util.NoteResult;

/**
 * BookService的实现类
 * @author Administrator
 *
 */
@Service
public class BookServiceImpl implements BookService{

	@Resource
	private NoteBookDAO noteBookDao;
	
	@Transactional(readOnly=true)	//使用Spring的事务回滚，若是查询中出现了异常，则回滚。
	public NoteResult loadBooks(String userId) {
		NoteResult result = new NoteResult();
		List<NoteBook> books = noteBookDao.findByUserId(userId);
		result.setMsg("加载成功！");
		result.setStatus(0);
		result.setData(books);//将books放入返回数据类的对象中
		return result;
	}
	
	
}
