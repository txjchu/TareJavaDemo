package org.tarena.note.controller.note;
/**
 * 载入笔记本book的notes列表
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller//--扫描
@RequestMapping("/note")
public class LoadNotesController {
	@Resource//--注入
	private NoteService noteService;
	
	//--【】----
	@ResponseBody
	@RequestMapping("/loadnotes.do")
	public NoteResult execute(String bookId){
		NoteResult result = noteService.loadBookNotes(bookId);
		return result;
	}
	
	
}
