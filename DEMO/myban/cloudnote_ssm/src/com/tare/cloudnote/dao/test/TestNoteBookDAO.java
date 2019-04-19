package com.tare.cloudnote.dao.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tare.cloudnote.dao.NoteBookDAO;
import com.tare.cloudnote.entity.NoteBook;

/**
 * ≤‚ ‘NoteBookDAO
 * @author Administrator
 *
 */
public class TestNoteBookDAO {

	private NoteBookDAO dao;
	@Before
	public void beforeTest(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = ac.getBean(NoteBookDAO.class);
	}

	@Test
	public void testFindAll(){
		List<NoteBook> books = dao.findAll();
		for(NoteBook book : books){
			System.out.println(book);
		}
	}
	@Test
	public void testFindByUserId(){
		List<NoteBook> books = dao.findByUserId("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		for(NoteBook book : books){
			System.out.println(book);
		}
	}
}
