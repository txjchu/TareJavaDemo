package com.tare.cloudnote.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tare.cloudnote.entity.NoteBook;

/**
 * NoteBook��DAO���
 * @author Administrator
 *
 */
@Repository
public interface NoteBookDAO {
	
	List<NoteBook> findAll();//��ѯ�����е�NoteBook
	
	List<NoteBook> findByUserId(String userId);//�����û�Id���ظ��û����еıʼǱ�
}
