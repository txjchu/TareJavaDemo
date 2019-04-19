package org.tarena.note.dao.test;

import java.util.List;
import org.junit.Test;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;

public class TestNoteDao extends SpringTest{
	
	@Test
	public void test1(){
		NoteDao noteDao = getContext().getBean("noteDao",NoteDao.class); 
		List<Note> list = noteDao.findByBookId("0037215c-09fe-4eaa-aeb5-25a340c6b39b");
		for(Note note: list){
			System.out.println(note.getCn_note_id()+" "+note.getCn_note_title());
		}		
//		System.out.println(list);
	}
	
	//≤‚ ‘findById()
}
