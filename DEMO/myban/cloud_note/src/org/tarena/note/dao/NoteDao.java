package org.tarena.note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.Note;
import org.tarena.note.vo.SearchBean;

@Repository
public interface NoteDao {
	
	public int deleteNotes(String[] ids);
	
	/**
	 * ��̬���·��������Բ�Ϊnull�Ĳ�����¡�
	 * @param note
	 * @return
	 */
	public int dynamicUpdate(Note note);
	/**
	 * ��ϲ�ѯ
	 * @param params
	 * @return
	 */
	public List<Note> findNotes(SearchBean params);
	public List<Note> findByBookId(String bookId);
	public Note findById(String id);
	public int save(Note note);
	
	public int update(Note note);
	public int updateStatus(String noteId);
	public int updateBookId(Note note);
}
