package org.tarena.note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.BookDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

@Service
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao bookDao;
	
	public NoteResult loadUserBooks(String userId) {
		List<NoteBook> books = 
			bookDao.findByUserId(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(books);
		return result;
	}

	public NoteResult addBook(String bookName, String userId) {
		//TODO 可以追加笔记本重名检测
		NoteBook book = new NoteBook();
		book.setCn_notebook_name(bookName);//设置笔记本名
		book.setCn_user_id(userId);//设置用户ID
		String bookId = NoteUtil.createId();
		book.setCn_notebook_id(bookId);//设置笔记本ID
		book.setCn_notebook_desc("");//设置描述
		book.setCn_notebook_type_id("5");//normal
		Timestamp time = new Timestamp(
				System.currentTimeMillis());
		book.setCn_notebook_createtime(time);//设置创建时间
		bookDao.save(book);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("创建笔记本成功");
		result.setData(bookId);//返回新建的笔记本ID
		return result;
	}

}


