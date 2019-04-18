package org.tarena.note.service;

import org.tarena.note.util.NoteResult;

public interface BookService {
	public NoteResult loadUserBooks(String userId);
}
