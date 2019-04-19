package org.tarena.note.service;
/**
 * 笔记相关服务器接口实现类
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
	private ShareDao shareDao; //注入一个定义，将来把内容传入
	
	//加载分享笔记的内容
	public NoteResult loadShare(String shareId){
		// TODO Auto-generated method stub
		Share share = shareDao.findByShareId(shareId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(share);
		result.setMsg("加载分享笔记信息成功");
		return result;
	}
	//查询分享的笔记列表
	public NoteResult searchNote(String keyword){
		// TODO Auto-generated method stub
		String title = "";
		if(keyword==null || "".equals(keyword)){
			title = "%";//查询所有
		}else{
			title = "%"+keyword+"%";
		}
		List<Share> list = shareDao.findLikeTitle(title);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("搜索成功");
		result.setData(list);
		
		return result;
	}
	//移动笔记业务
	public NoteResult moveNote(String noteId, String bookId) {
		// TODO Auto-generated method stub
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
				
			noteDao.dynamicUpdate(note);
		
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("转移笔记成功");
		return result;
	}
	//分享笔记
	public NoteResult shareNote(String noteId) {
		//根据cn_note_id检测判断笔记是否分享过
		NoteResult result = new NoteResult();
		Share has_share = shareDao.findByNoteId(noteId);
		if(has_share != null){
			result.setStatus(1);
			result.setMsg("该笔记已经分享过");
			return result;
		}
		
		// TODO Auto-generated method stub
		//根据笔记ID获取share信息进行cn_share表的添加
		Note note = noteDao.findById(noteId);
		
		Share share = new Share();
		share.setCn_note_id(noteId);
		share.setCn_share_title(note.getCn_note_title());//----【错误】
		share.setCn_share_body(note.getCn_note_body());
		String shareId = NoteUtil.createId();//通过NoteUtil生成
		share.setCn_share_id(shareId);
		shareDao.save(share);//添加cn_share记录
		
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		return result;
	}
	//回收笔记处理
	public NoteResult recycleNote(String noteId) {
		// TODO Auto-generated method stub
		NoteResult result = new NoteResult();
		
		//完善，以防noteId不符合，无效Id或者其他
		int rows = noteDao.updateStatus(noteId);//更新cn_note_status_id为2(删除状态)
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
	//编辑修改笔记
	public NoteResult updateNote(String noteId, String noteTitle,
			String noteBody) {
		// TODO Auto-generated method stub
		Note note = new Note();
		note.setCn_note_id(noteId);//设置笔记ID
		note.setCn_note_title(noteTitle);//设置笔记标题
		note.setCn_note_body(noteBody);//设置笔记内容
		note.setCn_note_last_modify_time(System.currentTimeMillis());//设置笔记修改时间
		noteDao.update(note);//更新cn_note表
		NoteResult result = new NoteResult(); 
		result.setStatus(0);
		result.setMsg("保存笔记信息成功");
		return result;
	}
	//添加笔记
	public NoteResult addNote(String bookId, String noteTitle, String userId) {
		// TODO Auto-generated method stub
		Note note = new Note();
		note.setCn_notebook_id(bookId);//设置笔记本ID
		note.setCn_note_title(noteTitle);//设置笔记标题
		note.setCn_user_id(userId);//设置用户ID
		
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);//设置笔记ID
		note.setCn_note_body("");//设置""--【】
		note.setCn_note_status_id("1");//正常的，标准的normal
		note.setCn_note_type_id("1");//normal
		Long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		
		noteDao.save(note);//保存
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(noteId);
		result.setMsg("创建笔记成功");
		
		return result;
	}
	
	//加载笔记本的笔记列表
	//--【重点】为什么，----查出来结果，放到result中。
	public NoteResult loadBookNotes(String bookId) {
		List<Note> notes = noteDao.findByBookId(bookId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(notes);
		result.setMsg("查询笔记成功");
		return result;
	}
	//加载笔记内容
	public NoteResult loadNote(String noteId) {
		Note note = noteDao.findById(noteId);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(note);
		result.setMsg("加载笔记信息成功");//如果加载失败,会触发ajax的error处理
		return result;
	}
	
	//高级搜索处理
	public NoteResult searchNotes(SearchBean params) {
		// TODO Auto-generated method stub
		//参数处理
		if(params.getTitle() != null && !"".equals(params.getTitle())){//标题不为null并且不为空
			
		}else{
			
		}
		//执行高级搜索处理
		List<Note> list = noteDao.findNotes(params);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(list);
		result.setMsg("检索成功");
		
		return result;
	}
	
	
}
