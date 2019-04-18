package org.tarena.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.entity.Note;
import org.tarena.note.util.NoteResult;

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

}
