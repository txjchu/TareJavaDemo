package org.tarena.note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.NoteBook;

@Repository
public interface BookDao {
	public List<NoteBook> findByUserId(String userId);
	public int save(NoteBook book);//����ֵ��������Ϊint����Ҫ�ʹ�������Ҫ�ͷ���
}
