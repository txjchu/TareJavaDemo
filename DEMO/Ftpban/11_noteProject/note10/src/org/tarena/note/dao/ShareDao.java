package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.Share;
import org.tarena.note.util.Page;

public interface ShareDao {
	public List<Share> findPage(Page page);
	
	public Share findById(String id);

	public List<Share> findLikeTitle(String title);
	
	public Share findByNoteId(String noteId);
	
	public int save(Share share);
	
}
