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
		result.setMsg("��ѯ�ɹ�");
		result.setData(books);
		return result;
	}

	public NoteResult addBook(String bookName, String userId) {
		//TODO ����׷�ӱʼǱ��������
		NoteBook book = new NoteBook();
		book.setCn_notebook_name(bookName);//���ñʼǱ���
		book.setCn_user_id(userId);//�����û�ID
		String bookId = NoteUtil.createId();
		book.setCn_notebook_id(bookId);//���ñʼǱ�ID
		book.setCn_notebook_desc("");//��������
		book.setCn_notebook_type_id("5");//normal
		Timestamp time = new Timestamp(
				System.currentTimeMillis());
		book.setCn_notebook_createtime(time);//���ô���ʱ��
		bookDao.save(book);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("�����ʼǱ��ɹ�");
		result.setData(bookId);//�����½��ıʼǱ�ID
		return result;
	}

}


