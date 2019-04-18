package org.tarena.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.dao.ShareDao;
import org.tarena.note.entity.Note;
import org.tarena.note.entity.Share;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;

@Service
@Transactional
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao;
	
	public NoteResult loadBookNotes(String bookId) {
		List<Note> notes = 
			noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(notes);
		result.setMsg("��ѯ�ʼǳɹ�");
		return result;
	}

	public NoteResult loadNote(String noteId) {
		Note note = noteDao.findById(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(note);
		result.setMsg("���رʼ���Ϣ�ɹ�");
		return result;
	}

	public NoteResult addNote(
		String bookId, String noteTitle, String userId) {
		
		Note note = new Note();
		note.setCn_notebook_id(bookId);//���ñʼǱ�ID
		note.setCn_note_title(noteTitle);//���ñʼǱ���
		note.setCn_user_id(userId);//�����û�ID
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);//���ñʼ�ID
		note.setCn_note_status_id("1");//normal
		note.setCn_note_type_id("1");//normal
		note.setCn_note_body("");//����""
		Long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		
		noteDao.save(note);//����
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("�����ʼǳɹ�");
		result.setData(noteId);
		return result;
	}

	public NoteResult updateNote(
			String noteId, 
			String noteTitle,
			String noteBody) {
		
		Note note = new Note();
		note.setCn_note_id(noteId);//�ʼ�ID
		note.setCn_note_title(noteTitle);//�ʼǱ���
		note.setCn_note_body(noteBody);//�ʼ�����
		note.setCn_note_last_modify_time(
			System.currentTimeMillis());//�޸�ʱ��
		noteDao.update(note);//����cn_note��
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("����ʼ���Ϣ�ɹ�");
		return result;
	}

	public NoteResult recycleNote(String noteId) {
		NoteResult result = new NoteResult();
		int rows = noteDao.updateStatus(noteId);
		if(rows==0){
			result.setStatus(1);
			result.setMsg("�������վʧ��");
			return result;
		}else{
			result.setStatus(0);
			result.setMsg("�������վ�ɹ�");
			return result;
		}
	}

	public NoteResult shareNote(String noteId) {
		//���ʼ��Ƿ��ѷ����
		NoteResult result = new NoteResult();
		Share has_share = 
			shareDao.findByNoteId(noteId);
		if(has_share != null){
			result.setStatus(1);
			result.setMsg("�ñʼ��ѷ����");
			return result;
		}
		//���ݱʼ�ID��ȡshare��Ϣ����cn_share�����
		Note note = noteDao.findById(noteId);
		Share share = new Share();
		share.setCn_note_id(noteId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		shareDao.save(share);//���cn_share��¼
	
		result.setStatus(0);
		result.setMsg("����ʼǳɹ�");
		return result;
	}

	public NoteResult moveNote(
			String noteId, String bookId) {
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		noteDao.updateBookId(note);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("ת�Ʊʼǳɹ�");
		return result;
	}

	public NoteResult searchNote(String keyword) {
		String title = "";
		if(keyword==null || "".equals(keyword)){
			title = "%";//��ѯ����
		}else{
			title = "%"+keyword.trim()+"%";
		}
		List<Share> list = 
			shareDao.findLikeTitle(title);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("�����ɹ�");
		result.setData(list);
		return result;
	}

	public NoteResult loadShare(String shareId) {
		
		Share share = shareDao.findById(shareId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("���ط���ʼ���Ϣ�ɹ�");
		result.setData(share);
		return result;
	}

}




