package org.tarena.note.service;
/**
 * ʵ����
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
 * public class MyException extends Exception(){}//����ع�����Ҫʹ��rollbackFor=MyException.class
 * public class MyException extends RuntimeException(){}//��ع�
 */
//@Transactional  Controller���õ�ʱ�򣬻�����Transactional��ʼʹ��ע�ⷽʽ��ʼ�������
@Service
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao bookDao;
	
	//��д��ʱ��Ӧ�ü��ϻع�����
	
	public NoteResult addBook(String bookName, String userId) {
		//TODO----�����ӡ�����׷�ӱʼǱ�������⣬
		NoteBook book = new NoteBook();
		book.setCn_notebook_name(bookName);	//���ñʼǱ�����
		book.setCn_user_id(userId);			//�����û�ID
		String bookId = NoteUtil.createId();		
		book.setCn_notebook_id(bookId);		//���ñʼǱ�ID
		book.setCn_notebook_desc("");		//���ñʼǱ�����
		book.setCn_notebook_type_id("5");	//����normal���͵ıʼ�
		Timestamp time = new Timestamp(System.currentTimeMillis());//----SQL��Timestamp��Ҫ����������˴�����ϵͳʱ���Long��ʽ��ֵ��
		book.setCn_notebook_createtime(time);//���ñʼǱ�����ʱ��
		bookDao.save(book);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("�ʼǴ����ɹ�");
		result.setData(bookId);//�����½��ıʼǱ�ID�����ڵ�ʱ�ͽ��½��ıʼǱ�ID����	��ʹ֮����������ҳ����ʾ
		
		return result;
	}

	@Transactional(readOnly=true)	//����Ҫ�޸ĵķ�������Ϊֻ���������Ż���Դ
	public NoteResult loadUserBooks(String userId) {
		List<NoteBook> books = bookDao.findByUserId(userId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("��ѯ�ɹ�");
		result.setData(books);
		
		return result;
	}
	
	//�˷���
	@Resource
	private BookJoinDao joinDao;
	
	public NoteResult loadBooks(){
		List<NoteBook> books = joinDao.findJoinUser();
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("��ѯ�ɹ�");
		result.setData(books);
		return result;
	}
	
}





