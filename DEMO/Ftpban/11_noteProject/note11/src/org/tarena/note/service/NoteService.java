package org.tarena.note.service;

import org.tarena.note.util.NoteResult;
import org.tarena.note.vo.SearchBean;

public interface NoteService {
	public NoteResult searchNotes(SearchBean params);
	
	public NoteResult loadShare(String shareId);
	
	public NoteResult searchNote(String keyword);
	
	public NoteResult moveNote(
		String noteId,String bookId);
	
	public NoteResult shareNote(String noteId);
	
	public NoteResult recycleNote(String noteId);
	
	public NoteResult updateNote(
		String noteId,String noteTitle,String noteBody);
	
	public NoteResult addNote(
		String bookId,String noteTitle,String userId);
	
	public NoteResult loadNote(String noteId);
	
	public NoteResult loadBookNotes(String bookId);
	
}
