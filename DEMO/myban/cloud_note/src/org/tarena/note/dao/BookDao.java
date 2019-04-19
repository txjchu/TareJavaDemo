package org.tarena.note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.NoteBook;

@Repository
public interface BookDao {
	public List<NoteBook> findByUserId(String userId);
	public int save(NoteBook book);//返回值类型设置为int，需要就传，不需要就放这
}
