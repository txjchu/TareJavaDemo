package org.tarena.note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.entity.User;
@Repository
public interface BookJoinDao {
	
	public List<NoteBook> findJoinUser();
	public List<NoteBook> findJoinUser1();
	public User findJoinBooks(String userId);
}
