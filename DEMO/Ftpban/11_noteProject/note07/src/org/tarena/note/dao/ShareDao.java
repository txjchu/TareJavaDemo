package org.tarena.note.dao;

import org.tarena.note.entity.Share;

public interface ShareDao {

	public Share findByNoteId(String noteId);
	
	public int save(Share share);
	
}
