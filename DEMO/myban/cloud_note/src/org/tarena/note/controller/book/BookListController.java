package org.tarena.note.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.note.service.BookService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class BookListController {
	
	@Resource
	private BookService bookService;
	
	@RequestMapping("/list.do")
//	@ResponseBody	//----如果加上的话就变成json响应了
	public String execute(Model model){//传入，以后会传出此参数
		NoteResult result = bookService.loadBooks();
		
		//仿佛model传递到book_list.jsp
		model.addAttribute("result",result);
		return "book_list";//找book_list.jsp
	}
}
