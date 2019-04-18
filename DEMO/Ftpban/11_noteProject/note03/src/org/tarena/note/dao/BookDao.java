package org.tarena.note.dao;

import java.util.List;

import org.tarena.note.entity.NoteBook;

public interface BookDao {
	public List<NoteBook> findByUserId(
			String userId);
}
