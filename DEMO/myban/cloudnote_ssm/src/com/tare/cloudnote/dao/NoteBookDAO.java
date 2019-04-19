package com.tare.cloudnote.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tare.cloudnote.entity.NoteBook;

/**
 * NoteBook的DAO组件
 * @author Administrator
 *
 */
@Repository
public interface NoteBookDAO {
	
	List<NoteBook> findAll();//查询出所有的NoteBook
	
	List<NoteBook> findByUserId(String userId);//按照用户Id加载该用户所有的笔记本
}
