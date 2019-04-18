//根据笔记本加载笔记列表
function loadNotes(){
	//将当前点中笔记本设置为选中状态
	$("#book_list li a").removeClass("checked");
	$(this).find("a").addClass("checked");
	//获取请求提交数据(获取当前点中li的笔记本ID)
	var bookId = $(this).data("bookId");
	//发送ajax请求
	$.ajax({
		url:path+"/note/loadnotes.do",
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
					createNoteLi(noteId,noteTitle);
				}
			}
		},
		error:function(){
			alert("加载笔记列表异常");
		}
	});
};

//创建笔记Li
function createNoteLi(noteId,noteTitle){
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

//确认添加笔记操作
function sureAddNote(){
	//获取请求数据
	var noteTitle = $("#input_note").val().trim();
	var $bookli = 
	  $("#book_list li a.checked").parent();
	var bookId = $bookli.data("bookId");
	//TODO 检测数据格式
	//发送ajax请求
	$.ajax({
		url:path+"/note/add.do",
		type:"post",
		data:{"bookId":bookId,
			"noteTitle":noteTitle,
			"userId":userId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				//获取返回的笔记ID
				var noteId = result.data;
				//拼一个li,添加到笔记列表
				createNoteLi(noteId,noteTitle);
				//关闭对话框
				closeWindow();
				//弹出提示框
				alert(result.msg);
			}
		},
		error:function(){
			alert("添加笔记异常");
		}
	});
};

//保存笔记信息
function updateNote(){
	var $a = $("#note_list li a.checked");
	if($a.length==0){
		alert("请选择笔记");
	}else{
		//获取请求参数
		var noteId = $a.parent().data("noteId");
		var noteTitle = $("#input_note_title").val().trim();
		var noteBody = um.getContent();
		//TODO 检测参数格式
		//发送ajax请求
		$.ajax({
			url:path+"/note/update.do",
			type:"post",
			data:{"noteId":noteId,
				"noteTitle":noteTitle,
				"noteBody":noteBody},
			dataType:"json",
			success:function(result){
				if(result.status==0){
					//更新列表标题noteTitle
					var str = '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
						str += noteTitle;
						str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					$a.html(str);//替换掉笔记li中<a>的内容
					//提示成功
					alert(result.msg);
				}
			},
			error:function(){
				alert("保存笔记异常");
			}
		});
	}
};

//显示笔记菜单
function showNoteMenu(){
	//获取当前点中的笔记li
	$li = $(this).parents("li");
	//获取当前li的菜单显示div
	var $menu = $li.find(".note_menu");
	if($menu.is(":hidden")){
		//将其他菜单隐藏
		$("#note_list .note_menu").hide();
		//将当前菜单div显示
		$menu.slideDown(1000);//动画显示
	}else{
		$menu.slideUp(1000);//动画隐藏
	}
	//return false;//阻止冒泡
};

//确认删除笔记（放入回收站）
function sureRecycleNote(){
	//获取笔记ID
	var $li = 
		$("#note_list li a.checked").parent();
	var noteId = $li.data("noteId");
	//发送Ajax
	$.ajax({
		url:path+"/note/recycle.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				//删除笔记列表的li
				$li.remove();
				um.setContent("");
				$("#input_note_title").val("");
				//关闭确认对话框
				closeWindow();
				//弹出成功提示
				alert(result.msg);
			}
		},
		error:function(){
			alert("删除笔记异常");
		}
	});
};

//分享笔记操作
function shareNote(){
	//获取笔记ID
	var $li = $(this).parents("li");
	var noteId = $li.data("noteId");
	//发送ajax请求
	$.ajax({
		url:path+"/note/share.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
			if(result.status==0){
				alert(result.msg);
			}else if(result.status==1){
				alert(result.msg);
			}
		},
		error:function(){
			alert("分享笔记异常");
		}
	});
};




