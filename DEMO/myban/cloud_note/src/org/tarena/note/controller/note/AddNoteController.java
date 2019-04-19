package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class AddNoteController {	//Ϊ�˰���������
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/add.do")//http://localhost:9080/cloud_note/note/add.do?bookId=1111&userId=2&noteTitle=33333
	@ResponseBody
	public NoteResult execute(String bookId,String noteTitle,String userId){
//		System.out.println("ִ����һ��AddNoteController");//----��ϰAOP
		NoteResult result = noteService.addNote(bookId, noteTitle, userId);
		return result ;
	}
}
