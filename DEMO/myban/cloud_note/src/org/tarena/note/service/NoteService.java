package org.tarena.note.service;
/**
 * 笔记相关服务器接口定义
 */
import org.tarena.note.entity.Note;
import org.tarena.note.util.NoteResult;
import org.tarena.note.vo.SearchBean;

public interface NoteService {
	
	public NoteResult searchNotes(SearchBean params);//--用SearchBean来接收传入的值
	
	
	public NoteResult loadBookNotes(String bookId);//返回是NoteResult笔记结果，加载的是笔记信息。
	public NoteResult loadNote(String noteId);
	public NoteResult loadShare(String shareId);
	public NoteResult addNote(String bookId,String noteTitle,String userId);
	public NoteResult searchNote(String keyword);
	public NoteResult recycleNote(String noteId);
	public NoteResult updateNote(String noteId,String noteTitle,String noteBody);
	public NoteResult shareNote(String noteId);
	public NoteResult moveNote(String noteId,String bookId);
}
