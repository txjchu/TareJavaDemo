//弹出创建笔记本对话框
function alertAddBookWindow(){
	//显示背景色div
	$(".opacity_bg").show();
	//弹出对话框div
	$("#can").load("http://localhost:8088/cloud_note/alert/alert_notebook.html");
};
//关闭对话框
function closeWindow(){
	$(".opacity_bg").hide();//隐藏背景色div
	$("#can").empty();//清空对话框内容
};

//弹出创建笔记对话框
function alertAddNoteWindow(){
	//检测是否选中笔记本
	var $a = $("#book_list li a.checked");
	if($a.length==0){//未选中提示错误
		alert("请选择笔记本");
	}else{//选中弹出对话框
		//显示背景色div
		$(".opacity_bg").show();
		//弹出对话框div
		$("#can").load("http://localhost:8088/cloud_note/alert/alert_note.html");
	}
};


