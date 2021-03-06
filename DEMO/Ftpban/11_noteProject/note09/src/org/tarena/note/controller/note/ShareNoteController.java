package org.tarena.note.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class ShareNoteController {

	@Resource
	private NoteService noteService;
	
	@RequestMapping("/share.do")
	@ResponseBody
	public NoteResult exeucte(String noteId){
		NoteResult result = 
			noteService.shareNote(noteId);
		return result;
	}
	
}



