//根据笔记本加载笔记列表
function loadNotes(){
	//将当前点中笔记本设置为选中状态
	$("#book_list li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取请求提交数据(获取当前点中li的笔记本ID)
	var bookId = $(this).data("bookId");
	//发送ajax请求
	$.ajax({
		url:"http://localhost:8088/cloud_note/note/loadnotes.do",
		type:"post",
		data:{"bookId":bookId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var notes = result.data;//笔记json对象数组
				//清除原有笔记列表
				$("#note_list").empty();
				//循环笔记信息生成li
				for(var i=0;i<notes.length;i++){
					var noteId = notes[i].cn_note_id;
					var noteTitle = notes[i].cn_note_title;
					//拼成一个笔记li
					var sli = '<li class="online">';
						sli += '  <a>';
						sli += '	<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
						sli += noteTitle;
						sli += '	<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
						sli += '  </a>';
						sli += '  <div class="note_menu" tabindex="-1">';
						sli += '	<dl>';
						sli += '		<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
						sli += '		<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
						sli += '		<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
						sli += '	</dl>';
						sli += '  </div>';
						sli += '</li>';
					//把noteId绑定到笔记li上
					var $li = $(sli);
					$li.data("noteId",noteId);
					//将li添加到笔记<ul id="note_list">列表区
					$("#note_list").append($li);
				}
			}
		},
		error:function(){
			alert("加载笔记列表异常");
		}
	});
};

//单击笔记显示笔记信息
function loadNote(){
	//设置单击的笔记选中
	$("#note_list li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取要提交的数据
	var noteId = $(this).data("noteId");
	//发送ajax请求
	$.ajax({
		url:"http://localhost:8088/cloud_note/note/load.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var note = result.data;//返回的笔记json对象
				var noteTitle = note.cn_note_title;//标题
				var noteBody = note.cn_note_body;//内容
				$("#input_note_title").val(noteTitle);//设置标题
				um.setContent(noteBody);//设置内容
			}
		},
		error:function(){
			alert("加载笔记信息异常");
		}
	});
};

