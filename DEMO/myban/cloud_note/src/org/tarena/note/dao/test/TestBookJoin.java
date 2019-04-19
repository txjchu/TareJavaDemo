package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.BookJoinDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.entity.User;
import org.tarena.note.util.SpringTest;


public class TestBookJoin extends SpringTest{
	
	@Test
	public void test2(){
		BookJoinDao dao = getContext().getBean("bookJoinDao",BookJoinDao.class);
		User user = dao.findJoinBooks("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println("该用户信息如下");
		System.out.println(user.getCn_user_name());
		System.out.println(user.getCn_user_password());
		System.out.println("包含的笔记本信息如下");
		for(NoteBook book:user.getBooks()){
			System.out.println(book.getCn_notebook_name());			
		}
	}
	
	@Test
	public void test1(){
		BookJoinDao dao = getContext().getBean("bookJoinDao",BookJoinDao.class);
		List<NoteBook> list = dao.findJoinUser();
		for(NoteBook books:list){
			System.out.println(books.getCn_notebook_name()+"\t"
					+books.getCn_notebook_createtime()+"\t"
					+books.getUser().getCn_user_name());
		}
	}
	
	
}
