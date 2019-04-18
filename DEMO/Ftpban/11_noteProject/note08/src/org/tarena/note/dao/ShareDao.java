package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.Share;

public interface ShareDao {

	public List<Share> findLikeTitle(String title);
	
	public Share findByNoteId(String noteId);
	
	public int save(Share share);
	
}
