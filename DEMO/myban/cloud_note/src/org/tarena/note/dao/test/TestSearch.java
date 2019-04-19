package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.SpringTest;
import org.tarena.note.vo.SearchBean;

public class TestSearch extends SpringTest {
	
	//org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.executor.ExecutorException: A query was run and no Result Maps were found for the Mapped Statement 'org.tarena.note.dao.NoteDao.findNotes'.  It's likely that neither a Result Type nor a Result Map was specified.
	
	@Test
	public void test1(){	//----¡¾´íÎó¡¿
		NoteDao dao = getContext().getBean("noteDao",NoteDao.class);
		
		SearchBean params = new SearchBean();
		
		params.setTitle("%²âÊÔ%");
//		params.setStatus("1");
//		params.setBeginTime("2016-01-01");
//		params.setEndTime("2016-01-18");
		List<Note> list = dao.findNotes(params);
		for(Note note:list){
			System.out.println(note.getCn_note_title());
		}
		System.out.println("½á¹ûÊý£º"+list.size());
	}
}
