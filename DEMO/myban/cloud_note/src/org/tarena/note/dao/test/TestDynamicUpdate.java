package org.tarena.note.dao.test;

import org.junit.Test;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;

public class TestDynamicUpdate extends SpringTest{
	@Test
	public void test1(){
		NoteDao noteDao = getContext().getBean("noteDao",NoteDao.class);
		Note note = new Note();
		note.setCn_note_status_id("2");
		note.setCn_notebook_id("1db556b9-d1dc-4ed9-8274-45cf0afbe859");
		note.setCn_note_id("24097647-fdb5-4617-ba74-2e1d567fa938");//--Ìõ¼þ
		noteDao.dynamicUpdate(note);
	}
}
