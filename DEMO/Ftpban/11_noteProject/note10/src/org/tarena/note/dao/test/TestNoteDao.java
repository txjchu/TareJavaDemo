package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;

public class TestNoteDao extends SpringTest{
	@Test
	public void test1(){
		NoteDao noteDao = getContext().getBean(
			"noteDao",NoteDao.class);
		List<Note> list = noteDao.findByBookId(
			"d92e6b86-e48a-485d-8f11-04a93818bb42");
		for(Note note: list){
			System.out.println(
				note.getCn_note_id()+""
				+note.getCn_note_title());
		}
	}
}



