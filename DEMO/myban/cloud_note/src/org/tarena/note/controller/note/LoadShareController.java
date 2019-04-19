package org.tarena.note.controller.note;
/**
 * 加载分享笔记内容控制器
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.NoteService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadShareController {
	
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadshare.do")
	@ResponseBody
	public NoteResult execute(String shareId){
		NoteResult result = noteService.loadShare(shareId);
		return result;
	}
	
}
