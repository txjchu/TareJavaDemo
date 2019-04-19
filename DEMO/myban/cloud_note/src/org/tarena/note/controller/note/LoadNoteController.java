package org.tarena.note.controller.note;
/**
 * ����note�ľ�����Ϣ
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
	
	@Resource
	private NoteService noteService;
	
	@ResponseBody
	@RequestMapping("/load.do")
	public NoteResult execute(String noteId){
		NoteResult result = noteService.loadNote(noteId);
		return result;
		
	}
}
