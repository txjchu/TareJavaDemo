package org.tarena.note.service.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.service.BookService;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.SpringTest;

public class TestBookService extends SpringTest{
	
	@Test
	public void test1(){
		BookService bookService = getContext().getBean("bookServiceImpl",BookService.class);
		NoteResult result = bookService.loadUserBooks("48595f52-b22c-4485-9244-f4004255b972");
		List<NoteBook> books =(List<NoteBook>) result.getData();//怎么变成字段记录原文(可读的)
		//System.out.println(books);
		for(NoteBook book:books){
			System.out.println(book.getCn_notebook_name());
		}
	}
}
