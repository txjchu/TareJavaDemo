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
		result.setMsg("查询笔记成功");
		return result;
	}

	public NoteResult loadNote(String noteId) {
		Note note = noteDao.findById(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(note);
		result.setMsg("加载笔记信息成功");
		return result;
	}

	public NoteResult addNote(
		String bookId, String noteTitle, String userId) {
		
		Note note = new Note();
		note.setCn_notebook_id(bookId);//设置笔记本ID
		note.setCn_note_title(noteTitle);//设置笔记标题
		note.setCn_user_id(userId);//设置用户ID
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);//设置笔记ID
		note.setCn_note_status_id("1");//normal
		note.setCn_note_type_id("1");//normal
		note.setCn_note_body("");//设置""
		Long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		
		noteDao.save(note);//保存
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("创建笔记成功");
		result.setData(noteId);
		return result;
	}

	public NoteResult updateNote(
			String noteId, 
			String noteTitle,
			String noteBody) {
		
		Note note = new Note();
		note.setCn_note_id(noteId);//笔记ID
		note.setCn_note_title(noteTitle);//笔记标题
		note.setCn_note_body(noteBody);//笔记内容
		note.setCn_note_last_modify_time(
			System.currentTimeMillis());//修改时间
		noteDao.update(note);//更新cn_note表
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("保存笔记信息成功");
		return result;
	}

	public NoteResult recycleNote(String noteId) {
		NoteResult result = new NoteResult();
		int rows = noteDao.updateStatus(noteId);
		if(rows==0){
			result.setStatus(1);
			result.setMsg("放入回收站失败");
			return result;
		}else{
			result.setStatus(0);
			result.setMsg("放入回收站成功");
			return result;
		}
	}

	public NoteResult shareNote(String noteId) {
		//检查笔记是否已分享过
		NoteResult result = new NoteResult();
		Share has_share = 
			shareDao.findByNoteId(noteId);
		if(has_share != null){
			result.setStatus(1);
			result.setMsg("该笔记已分享过");
			return result;
		}
		//根据笔记ID获取share信息进行cn_share表插入
		Note note = noteDao.findById(noteId);
		Share share = new Share();
		share.setCn_note_id(noteId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		String shareId = NoteUtil.createId();
		share.setCn_share_id(shareId);
		shareDao.save(share);//添加cn_share记录
	
		result.setStatus(0);
		result.setMsg("分享笔记成功");
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
		result.setMsg("转移笔记成功");
		return result;
	}

	public NoteResult searchNote(String keyword) {
		String title = "";
		if(keyword==null || "".equals(keyword)){
			title = "%";//查询所有
		}else{
			title = "%"+keyword.trim()+"%";
		}
		List<Share> list = 
			shareDao.findLikeTitle(title);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("搜索成功");
		result.setData(list);
		return result;
	}

	public NoteResult loadShare(String shareId) {
		
		Share share = shareDao.findById(shareId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("加载分享笔记信息成功");
		result.setData(share);
		return result;
	}

}




