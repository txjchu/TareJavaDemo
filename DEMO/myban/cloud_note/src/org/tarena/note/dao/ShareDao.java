package org.tarena.note.dao;
/**
 * ��������share��صķ���
 * ��ӦShareMapper.xml
 * MyBatis��ôʹ�ã�
 * ��***�����˷�װ��ֻ��Ҫʹ�����ṩSQL��䣬�����JSON�Զ�����DAO����
 */
import java.util.List;

import org.springframework.stereotype.Repository;
import org.tarena.note.entity.Share;
@Repository
public interface ShareDao {
	
	public int save(Share share);				//����ʼ�
	public Share findByNoteId(String noteId);	//��������ʼ�
//	public int updateByNoteId(String noteId);
	public List<Share> findLikeTitle(String title);//
	public Share findByShareId(String shareId);	//���ط���ʼǵ�����
}
