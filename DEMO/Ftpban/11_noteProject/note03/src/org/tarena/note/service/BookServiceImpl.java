package org.tarena.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.BookDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.util.NoteResult;

@Service
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao bookDao;
	
	public NoteResult loadUserBooks(String userId) {
		List<NoteBook> books = 
			bookDao.findByUserId(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("≤È—Ø≥…π¶");
		result.setData(books);
		return result;
	}

}
