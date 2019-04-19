package org.tarena.note.service;
/**
 * �ʼ���ط������ӿ�ʵ����
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.NoteDao;
import org.tarena.note.dao.ShareDao;
import org.tarena.note.entity.Note;
import org.tarena.note.entity.Share;
import org.tarena.note.util.NoteResult;
import org.tarena.note.util.NoteUtil;
import org.tarena.note.vo.SearchBean;
@Service
public class NoteServiceImpl implements NoteService{
	@Resource
	private NoteDao noteDao;
	@Resource
	private ShareDao shareDao; //ע��һ�����壬���������ݴ���
	
	//���ط���ʼǵ�����
	public NoteResult loadShare(String shareId){
		// TODO Auto-generated method stub
		Share share = shareDao.findByShareId(shareId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(share);
		result.setMsg("���ط���ʼ���Ϣ�ɹ�");
		return result;
	}
	//��ѯ����ıʼ��б�
	public NoteResult searchNote(String keyword){
		// TODO Auto-generated method stub
		String title = "";
		if(keyword==null || "".equals(keyword)){
			title = "%";//��ѯ����
		}else{
			title = "%"+keyword+"%";
		}
		List<Share> list = shareDao.findLikeTitle(title);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("�����ɹ�");
		result.setData(list);
		
		return result;
	}
	//�ƶ��ʼ�ҵ��
	public NoteResult moveNote(String noteId, String bookId) {
		// TODO Auto-generated method stub
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
				
			noteDao.dynamicUpdate(note);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("ת�Ʊʼǳɹ�");
		return result;
	}
	//����ʼ�
	public NoteResult shareNote(String noteId) {
		//����cn_note_id����жϱʼ��Ƿ�����
		NoteResult result = new NoteResult();
		Share has_share = shareDao.findByNoteId(noteId);
		if(has_share != null){
			result.setStatus(1);
			result.setMsg("�ñʼ��Ѿ������");
			return result;
		}
		
		// TODO Auto-generated method stub
		//���ݱʼ�ID��ȡshare��Ϣ����cn_share������
		Note note = noteDao.findById(noteId);
		
		Share share = new Share();
		share.setCn_note_id(noteId);
		share.setCn_share_title(note.getCn_note_title());//----������
		share.setCn_share_body(note.getCn_note_body());
		String shareId = NoteUtil.createId();//ͨ��NoteUtil����
		share.setCn_share_id(shareId);
		shareDao.save(share);//���cn_share��¼
		
		result.setStatus(0);
		result.setMsg("����ʼǳɹ�");
		return result;
	}
	//���ձʼǴ���
	public NoteResult recycleNote(String noteId) {
		// TODO Auto-generated method stub
		NoteResult result = new NoteResult();
		
		//���ƣ��Է�noteId�����ϣ���ЧId��������
		int rows = noteDao.updateStatus(noteId);//����cn_note_status_idΪ2(ɾ��״̬)
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
	//�༭�޸ıʼ�
	public NoteResult updateNote(String noteId, String noteTitle,
			String noteBody) {
		// TODO Auto-generated method stub
		Note note = new Note();
		note.setCn_note_id(noteId);//���ñʼ�ID
		note.setCn_note_title(noteTitle);//���ñʼǱ���
		note.setCn_note_body(noteBody);//���ñʼ�����
		note.setCn_note_last_modify_time(System.currentTimeMillis());//���ñʼ��޸�ʱ��
		noteDao.update(note);//����cn_note��
		NoteResult result = new NoteResult(); 
		result.setStatus(0);
		result.setMsg("����ʼ���Ϣ�ɹ�");
		return result;
	}
	//��ӱʼ�
	public NoteResult addNote(String bookId, String noteTitle, String userId) {
		// TODO Auto-generated method stub
		Note note = new Note();
		note.setCn_notebook_id(bookId);//���ñʼǱ�ID
		note.setCn_note_title(noteTitle);//���ñʼǱ���
		note.setCn_user_id(userId);//�����û�ID
		
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);//���ñʼ�ID
		note.setCn_note_body("");//����""--����
		note.setCn_note_status_id("1");//�����ģ���׼��normal
		note.setCn_note_type_id("1");//normal
		Long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		
		noteDao.save(note);//����
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(noteId);
		result.setMsg("�����ʼǳɹ�");
		
		return result;
	}
	
	//���رʼǱ��ıʼ��б�
	//--���ص㡿Ϊʲô��----�����������ŵ�result�С�
	public NoteResult loadBookNotes(String bookId) {
		List<Note> notes = noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(notes);
		result.setMsg("��ѯ�ʼǳɹ�");
		return result;
	}
	//���رʼ�����
	public NoteResult loadNote(String noteId) {
		Note note = noteDao.findById(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(note);
		result.setMsg("���رʼ���Ϣ�ɹ�");//�������ʧ��,�ᴥ��ajax��error����
		return result;
	}
	
	//�߼���������
	public NoteResult searchNotes(SearchBean params) {
		// TODO Auto-generated method stub
		//��������
		if(params.getTitle() != null && !"".equals(params.getTitle())){//���ⲻΪnull���Ҳ�Ϊ��
			
		}else{
			
		}
		//ִ�и߼���������
		List<Note> list = noteDao.findNotes(params);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(list);
		result.setMsg("�����ɹ�");
		
		return result;
	}
	
	
}
