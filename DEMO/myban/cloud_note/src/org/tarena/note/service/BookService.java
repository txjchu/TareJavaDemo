package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface BookService {
	public NoteResult addBook(String bookName,String userId);//Controller���պ���˴�
	
	public NoteResult loadUserBooks(String userId);

	public NoteResult loadBooks();
}
