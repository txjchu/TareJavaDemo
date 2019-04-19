//弹出创建笔记本的对话框
function alertAddBookWindow(){
			//弹出背景色----搜索，如果只有一个类的元素，用类选择器
			$(".opacity_bg").show();
			//弹出对话框
			$("#can").load(path+"/alert/alert_notebook.html");//ajax提供的。可以发送请求，将	加载到	，后面可以回调个function()
			
		};
//关闭对话框，(所有)
function closeWindow(){	//使用样式选择器，选择多种元素。
			$(".opacity_bg").hide();//隐藏背景色div
			$("#can").empty();		//清空对话框内容，达到隐藏对话框效果
		};

//弹出创建笔记对话框
function alertAddNoteWindow(){
			//检测笔记本是否选中
				var $a = $("#book_list li a.checked");
				//alert($a.length);	//--Ajax的类型就是Object
				if($a.length==0){//未选中提示错误
					alert("请选择笔记本");
				}else{	//选中弹出对话框
					//弹出背景色----搜索，如果只有一个类的元素，用类选择器
					$(".opacity_bg").show();
					//弹出对话框
					$("#can").load(path+"/alert/alert_note.html");//ajax提供的。可以发送请求，将	加载到	，后面可以回调个function()
				}
	}

//弹出确认删除笔记对话框
function alertRecycleNoteWindow(){
		//显示背景色div
		$(".opacity_bg").show();
		//弹出对话框div
		$("#can").load(path+"/alert/alert_delete_note.html");
}
		
//弹出移动笔记对话框
function alertMoveNoteWindow(){
		//显示背景色div
		$(".opacity_bg").show();
		//弹出对话框div			
			/**
			 * 【重点】【同步异步】两种方式，1从数据库查询调数据，2加载当前页面的book_list。注意数据加载的时机和速度。
			 * $.post(url,function(){
			 * 	js代码1
			 * })
			 * js代码就2
			 * 
			 * 异步顺序：1.发送ajax请求，2js代码2，3js代码1
			 * 同步顺序：1发送ajax请求，2js代码1，3js代码2
			 */
		var url = path+"/alert/alert_move.html";
		$("#can").load(url,function(){
			//获取笔记本信息填充下拉单选项
			var bookLis = $("#book_list li");	//----【【】】JS里DOM对象，
			for(var i=0;i<bookLis.length;i++){//循环每个笔记本li
				var $li = $(bookLis[i]);//----DOM对象转换为jQuery对象
				var bookName = $li.text().trim();//获取笔记本ID
				var bookId = $li.data("bookId");		//----【【】】
				//alert(bookId);
				//alert(bookName);
				//拼成一个option下拉菜单
				var opt = "<option value='"+bookId+"'>"+bookName+"</option>";
				//将Option函数添加到select
				$("#moveSelect").append(opt);	//----【【jQuery对象的方法】】把元素追加到最后一个选项。
			}			
		});
		
}

//			var $bookli = $("#book_list li a.checked").parent();//由当前元素找父元素或子元素----按状态选择器a.checked--.parent()找其父元素
//			var bookId = $bookli.data("bookId");
//			alert($bookli);	//--【】
					//检测笔记本是否选中
//			if(bookId==undefined){//未选中提示错误
//				alert("请选择笔记本");
		