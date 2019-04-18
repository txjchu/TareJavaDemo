package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface NoteService {
	public NoteResult addNote(
		String bookId,String noteTitle,String userId);
	
	public NoteResult loadNote(String noteId);
	
	public NoteResult loadBookNotes(String bookId);
	
}
