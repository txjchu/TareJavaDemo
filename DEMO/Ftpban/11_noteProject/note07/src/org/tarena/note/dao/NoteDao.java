package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.Note;

public interface NoteDao {
	public int updateStatus(String noteId);
	public int update(Note note);
	public int save(Note note);
	public Note findById(String id);
	public List<Note> findByBookId(String bookId);
}
