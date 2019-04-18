package org.tarena.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

@Service
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDao noteDao;
	
	public NoteResult loadBookNotes(String bookId) {
		List<Note> notes = 
			noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(notes);
		result.setMsg("查询笔记成功");
		return result;
	}

	public NoteResult loadNote(String noteId) {
		Note note = noteDao.findById(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(note);
		result.setMsg("加载笔记信息成功");
		return result;
	}

	public NoteResult addNote(
		String bookId, String noteTitle, String userId) {
		
		Note note = new Note();
		note.setCn_notebook_id(bookId);//设置笔记本ID
		note.setCn_note_title(noteTitle);//设置笔记标题
		note.setCn_user_id(userId);//设置用户ID
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);//设置笔记ID
		note.setCn_note_status_id("1");//normal
		note.setCn_note_type_id("1");//normal
		note.setCn_note_body("");//设置""
		Long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		
		noteDao.save(note);//保存
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("创建笔记成功");
		result.setData(noteId);
		return result;
	}

}




