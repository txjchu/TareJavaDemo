package org.tarena.note.controller.note;
/**
 * ����ʼǱ�book��notes�б�
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller//--ɨ��
@RequestMapping("/note")
public class LoadNotesController {
	@Resource//--ע��
	private NoteService noteService;
	
	//--����----
	@ResponseBody
	@RequestMapping("/loadnotes.do")
	public NoteResult execute(String bookId){
		NoteResult result = noteService.loadBookNotes(bookId);
		return result;
	}
	
	
}
