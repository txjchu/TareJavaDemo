package com.tare.cloudnote.controller.book;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tare.cloudnote.service.BookService;
import com.tare.cloudnote.util.NoteResult;

/**
 * 处理加载用户所有笔记本业务的Controller组件
 */
@Controller
@RequestMapping("/notebook")
public class LoadUserBooksController {

	@Resource
	private BookService service;
	
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId){
		NoteResult result = null;
		result = service.loadBooks(userId);
		return result ;
	}
}
