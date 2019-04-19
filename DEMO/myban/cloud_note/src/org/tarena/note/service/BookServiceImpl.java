package org.tarena.note.service;
/**
 * 实现类
 */

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.BookDao;
import org.tarena.note.dao.BookJoinDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

/**
 * public class MyException extends Exception(){}//不会回滚，需要使用rollbackFor=MyException.class
 * public class MyException extends RuntimeException(){}//会回滚
 */
//@Transactional  Controller调用的时候，会切入Transactional开始使用注解方式开始事务管理
@Service
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao bookDao;
	
	//读写的时候应该加上回滚属性
	
	public NoteResult addBook(String bookName, String userId) {
		//TODO----【发挥】可以追加笔记本重名检测，
		NoteBook book = new NoteBook();
		book.setCn_notebook_name(bookName);	//设置笔记本名称
		book.setCn_user_id(userId);			//设置用户ID
		String bookId = NoteUtil.createId();		
		book.setCn_notebook_id(bookId);		//设置笔记本ID
		book.setCn_notebook_desc("");		//设置笔记本描述
		book.setCn_notebook_type_id("5");	//设置normal类型的笔记
		Timestamp time = new Timestamp(System.currentTimeMillis());//----SQL中Timestamp需要传如参数，此处传入系统时间的Long形式的值。
		book.setCn_notebook_createtime(time);//设置笔记本创建时间
		bookDao.save(book);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("笔记创建成功");
		result.setData(bookId);//返回新建的笔记本ID，用于当时就将新建的笔记本ID传入	，使之可以立即在页面显示
		
		return result;
	}

	@Transactional(readOnly=true)	//不需要修改的方法设置为只读，可以优化资源
	public NoteResult loadUserBooks(String userId) {
		List<NoteBook> books = bookDao.findByUserId(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(books);
		
		return result;
	}
	
	//此方法
	@Resource
	private BookJoinDao joinDao;
	
	public NoteResult loadBooks(){
		List<NoteBook> books = joinDao.findJoinUser();
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(books);
		return result;
	}
	
}





