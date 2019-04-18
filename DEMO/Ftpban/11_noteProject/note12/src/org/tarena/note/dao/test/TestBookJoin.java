package org.tarena.note.dao.test;

import java.util.List;

import org.junit.Test;
import org.tarena.note.dao.BookJoinDao;
import org.tarena.note.entity.NoteBook;
import org.tarena.note.entity.User;
import org.tarena.note.util.SpringTest;

public class TestBookJoin extends SpringTest{
	@Test
	public void test2(){
		BookJoinDao dao = getContext().getBean(
			"bookJoinDao",BookJoinDao.class);
		User user = dao.findJoinBooks1(
			"89ec1b2b-e7c4-4022-8539-c61eedbe5578");
		System.out.println("���û���Ϣ����");
		System.out.println(user.getCn_user_name());
		System.out.println(user.getCn_user_password());
		System.out.println("�����ıʼǱ���Ϣ����");
		for(NoteBook book : user.getBooks()){
			System.out.println(book.getCn_notebook_name());
		}
	}
	
	@Test
	public void test1(){
		BookJoinDao dao = getContext().getBean(
			"bookJoinDao",BookJoinDao.class);
		List<NoteBook> list = dao.findJoinUser1();
		for(NoteBook book : list){
			System.out.println(book.getCn_notebook_name()+"\t"
				+book.getCn_notebook_createtime()+"\t"
				+book.getUser().getCn_user_name());
		}
	}
}





