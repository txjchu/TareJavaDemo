package org.tarena.note.dao;
/**
 * 声明定义share相关的方法
 * 对应ShareMapper.xml
 * MyBatis怎么使用：
 * 对***进行了封装，只需要使用者提供SQL语句，会根据JSON自动产生DAO对象
 */
import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.Share;
@Repository
public interface ShareDao {
	
	public int save(Share share);				//分享笔记
	public Share findByNoteId(String noteId);	//搜索分享笔记
//	public int updateByNoteId(String noteId);
	public List<Share> findLikeTitle(String title);//
	public Share findByShareId(String shareId);	//加载分享笔记的内容
}
