package org.tarena.note.service;
/**
 * �ʼ���ط������ӿڶ���
 */
import org.tarena.note.entity.Note;
import org.tarena.note.util.NoteResult;
import org.tarena.note.vo.SearchBean;

public interface NoteService {
	
	public NoteResult searchNotes(SearchBean params);//--��SearchBean�����մ����ֵ
	
	
	public NoteResult loadBookNotes(String bookId);//������NoteResult�ʼǽ�������ص��Ǳʼ���Ϣ��
	public NoteResult loadNote(String noteId);
	public NoteResult loadShare(String shareId);
	public NoteResult addNote(String bookId,String noteTitle,String userId);
	public NoteResult searchNote(String keyword);
	public NoteResult recycleNote(String noteId);
	public NoteResult updateNote(String noteId,String noteTitle,String noteBody);
	public NoteResult shareNote(String noteId);
	public NoteResult moveNote(String noteId,String bookId);
}
