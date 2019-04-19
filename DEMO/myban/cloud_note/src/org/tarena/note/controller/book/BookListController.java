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
//	@ResponseBody	//----������ϵĻ��ͱ��json��Ӧ��
	public String execute(Model model){//���룬�Ժ�ᴫ���˲���
		NoteResult result = bookService.loadBooks();
		
		//�·�model���ݵ�book_list.jsp
		model.addAttribute("result",result);
		return "book_list";//��book_list.jsp
	}
}
