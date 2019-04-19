//列表单击，加载笔记列表内容信息
function loadNotes(){
				//切换中间列表区显示--【】---？？加#号是加jQuery
				$("#pc_part_2").show();//全部笔记列表
				$("#pc_part_3").show();//编辑笔记区
				$("#pc_part_5").hide();//预览笔记区
				$("#pc_part_6").hide();//搜索结果列表
				$("#pc_part_4").hide();//回收站列表
				$("#pc_part_7").hide();//收藏列表
				$("#pc_part_8").hide();//活动列表
			//alert("----");
			//将当前点中笔记本设置为选中状态
			$("#book_list li a").removeClass("checked");
			$(this).find("a").addClass("checked");
			//获取请求提交数据(获取当前点中li的笔记本ID)
			var bookId = $(this).data("bookId");
			//发送ajax请求
			//alert(bookId);
			$.ajax({
				url:path+"/note/loadnotes.do",	//【【错误】】url没有写全
				type:"post",
				data:{"bookId":bookId},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						var notes = result.data;//笔记json对象
						//清除原有笔记列表
						$("#note_list").empty();
						//循环笔记信息生成li
						for(var i=0;i<notes.length;i++){	//【【错误】】notes少写s
							var noteId = notes[i].cn_note_id;
							var noteTitle = notes[i].cn_note_title;
							//拼成一个笔记的li
							createNoteLi(noteId,noteTitle);
						}
					}
				},
				error:function(){
					alert("加载笔记列表异常");
				}
			});
		}
//添加笔记
function sureAddNote(){
			//获取请求数据
			var noteTitle = $("#input_note").val().trim();
			var $bookli = $("#book_list li a.checked").parent(); //--找其父元素--【】.parent();
			var bookId = $bookli.data("bookId");
			
			//alert(bookId);---？？ERROR弹出框提示
			//TODO 检测数据格式--是否名称重复
			//发送ajax请求
			$.ajax({
				url:path+"/note/add.do",
				type:"post",
				data:{"bookId":bookId,"noteTitle":noteTitle,"userId":userId},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						//获取返回的笔记ID
						var noteId = result.data;
						//拼接一个li,添加到笔记列表
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
		}
//保存笔记
function updateNote(){
			//alert("----");----通过
			//判断笔记内容是否为空
			var $a = $("#note_list li a.checked");
			if($a.length==0){
				alert("请选择一则笔记");
			}else{
				//获取请求参数
				var noteId = $a.parent().data("noteId");//--由当前a，找到其父元素li上绑定的数据中的noteId
				//--alert(noteId);
				var noteTitle = $("#input_note_title").val().trim();
				var noteBody = um.getContent();
				//TODO检测参数格式
				//发送Ajax请求
				$.ajax({
					url:path+"/note/update.do",
					type:"post",
					data:{"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody},
					dataType:"json",
					success:function(result){
						if(result.status==0){
							//更新列表标题noteTitle--为了更改笔记标题，在编辑笔记模块中更改
							var str  = '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'; 
								str += noteTitle;
								str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
							$a.html(str);//替换掉笔记li中的<a>中的内容	
							//提示修改内容成功
							alert(result.msg);
						}
					},
					error:function(){
						alert("保存笔记异常");
					}
				});
			}
		}
//创建笔记Li
function createNoteLi(noteId,noteTitle){
				var sli  = '<li class="online">';
					sli += '	<a>';
					sli += '		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'; 
					sli += noteTitle;
					sli += '		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
					sli += '	</a>';
					sli += '	<div class="note_menu" tabindex="-1">';
					sli += '		<dl>';
					sli += '			<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';
					sli += '			<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
					sli += '			<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
					sli += '		</dl>';
					sli += '	</div>';
					sli += '</li>';							
			//把noteId绑定到笔记li上
			var $li = $(sli);
			$li.data("noteId",noteId);
			//将li添加到笔记ul列表区<ul id="note_list">
			$("#note_list").append($li);

}
//加载笔记中的信息
function loadNote(){
			
				//----单击笔记列表，去除多重选择
				$("#note_list li a").removeClass("checked");
				$(this).find("a").addClass("checked");
	
			//获取要提交的数据
			var noteId = $(this).data("noteId");
			//发送ajax请求
				//alert(noteId);
			$.ajax({
				url:path+"/note/load.do",
				type:"post",
				data:{"noteId":noteId},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						var note = result.data;//笔记ajax对象
						var noteTitle = note.cn_note_title;//标题
						var noteBody = note.cn_note_body;//内容
						$("#input_note_title").val(noteTitle);//设置标题
						um.setContent(noteBody);//设置加载笔记中的内容
					}					
				},
				error:function(){
					alert("加载笔记信息异常");
				}
			});			
		}

//显示笔记菜单
function showNoteMenu(){
			//alert("btn----");--通过
			//显示菜单div
			//获取当前点中的笔记的li
			$li = $(this).parents("li");//--.parents()寻找父辈的父辈
			//将当前li的菜单显示----或者.toggle()方法切换
			var $menu = $li.find(".note_menu");
			if($menu.is(":hidden")){	//.is(":hidden")选择器，选择属性为xx的元素
				//将其他菜单隐藏
				$("#note_list .note_menu").hide();
				$menu.slideDown(500);//采用动态下拉方式显示
			}else{
				$menu.slideUp(150);//动画隐藏
			}
				//----给body追加单击事件，单击其他处隐藏菜单
//			return false;//阻止冒泡----【阻止冒泡】，比专用的方法简单。
			
}
//分享笔记操作
function shareNote(){
			//获取笔记ID
			var $li = $(this).parents("li");
			var noteId = $li.data("noteId");
			//发送ajax请求
			$.ajax({
				url:path+"/note/share.do",
				type:"post",
				data:{"noteId":noteId},//传给controller
				dateType:"json",//传出类型
				success:function(result){//成功，从controller传入result
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
		}
//确认删除笔记（放入回收站）
function sureRecycleNote(){	//id为sureRecycleNote
					//获取笔记ID
				var $li = $("#note_list li a.checked").parent();
				var noteId = $li.data("noteId");
				alert(noteId);//--alertRecycleNoteWindow() note.js:184
					//发送Ajax请求
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
			}
//确认转移笔记操作
function sureMoveNote(){
			//获取请求参数
//			var $bookLi = $("#book_list li a.checked").parent();
//			var bookId = $bookLi.data("bookId");
			var bookId = $("#moveSelect").val();//如果是下拉选的话，则不需要写成"#moveSelect option:selected"
			var $noteLi = $("#note_list li a.checked").parent();
			var noteId = $noteLi.data("noteId");
			alert(bookId);
			//发送ajax请求
			$.ajax({
				url:path+"/note/move.do",
				type:"post",
				data:{"noteId":noteId,"bookId":bookId},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						//关闭对话框
						closeWindow();
						//移除笔记li
						$noteLi.remove();
						//弹出提示信息
						alert(result.msg);
					}
				},
				error:function(){
					alert("移动笔记异常");
				}
			});
		}
//查询分享笔记列表的操作
function searchShareNotes(event){
			//alert("---");
			//键盘事件中有个event事件有个keyCode属性
			var code = event.keyCode;	//----浏览器兼容性，火狐ReferenceError: event is not defined,在function()方法中传入event参数
			//alert(code);-------------可以查看键盘各个键的Code码
			if(code==13){//触发回车键
					//切换中间列表区显示--【】
					//---？？加#号是加jQuery
					$("#pc_part_6").show();//搜索结果列表
					$("#pc_part_5").show();//预览笔记区
					$("#pc_part_3").hide();//编辑笔记区
					$("#pc_part_2").hide();//全部笔记列表
					$("#pc_part_4").hide();//回收站列表
					$("#pc_part_7").hide();//收藏列表
					$("#pc_part_8").hide();//活动列表
				//获取请求参数
				var keyword = $("#search_note").val().trim();
				//发送ajax请求
				$.ajax({
					url:path+"/note/search.do",
					type:"post",
					data:{"keyword":keyword},
					dataType:"json",
					success:function(result){
						if(result.status==0){
							var notes = result.data;
								//清空原有列表
								$("#search_list").empty();
							//循环生成列表li
							for(var i=0;i<notes.length;i++){
								var title = notes[i].cn_share_title;
								var id = notes[i].cn_share_id;
								//拼一个笔记列表li
								var sli  = '<li class="online">';
									sli += '	<a>';
									sli += '		<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'; 
									sli += title;
									sli += '		<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-star"></i></button>';
									sli += '	</a>';									
									sli += '</li>';	
									//绑定分享ID
									var $li = $(sli);
									$li.data("shareId",id);
									//添加到搜索结果列表区
									$("#search_list").append($li);
							}
						}	
					},
					error:function(){
						alert("搜索分享笔记异常");
					}
				});
			}
		}