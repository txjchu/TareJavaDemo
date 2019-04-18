package org.tarena.note.dao.test;

import org.junit.Test;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;

public class TestDynamicUpdate extends SpringTest{
	@Test
	public void test1(){
		NoteDao dao = getContext().getBean(
			"noteDao",NoteDao.class);
//		Note note = new Note();
////		note.setCn_notebook_id(
////			"e46239d6-4f54-426c-a448-f7a0d45f9425");
//		note.setCn_note_status_id("2");
//		note.setCn_note_id(
//			"fed920a0-573c-46c8-ae4e-368397846efd");
//		dao.dynamicUpdate(note);
		String[] ids = {"ebd65da6-3f90-45f9-b045-782928a5e2c0",
				"9187ffd3-4c1e-4768-9f2f-c600e835b823",
				"3febebb3-a1b7-45ac-83ba-50cdb41e5fc1"};
		int rows = dao.deleteNotes(ids);
		System.out.println("É¾³ý¼ÇÂ¼Êý£º"+rows);
	}
	
}
