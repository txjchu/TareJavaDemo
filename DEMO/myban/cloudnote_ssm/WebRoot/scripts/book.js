//根据用户ID加载笔记本列表
function loadBooks(){
//加载笔记本列表
$.ajax({
	url:path+"/notebook/loadbooks.do",
	type:"post",
	//		----异步变同步
	async:false,
	data:{"userId":userId},
	dataType:"json",
	success:function(result){
		if(result.status==0){
			var books = result.data;//笔记本json对象数组
				//清除原有笔记本列表
				$("#book_list").empty();
			//循环books生成笔记本列表li
			for(var i=0;i<books.length;i++){
				var bookId = books[i].cn_notebook_id;
				var bookName = books[i].cn_notebook_name;
				//拼成一个li(li元素没有value属性，只有表单元素有value属性)
					createBookLi(bookName,bookId)
			}
		}
	},
	error:function(){
		alert("加载笔记本列表失败");
	}
});
}
//创建新笔记本
function sureAddBook(){
			//获取请求提交数据
			var bookName = $("#input_notebook").val().trim();//----.val()取值，.trim()去除空字符串
			//TODO 可以追加检查，名称是否重复
			//发送ajax请求
			$.ajax({
				url:"http://localhost:9080/cloud_note/notebook/add.do",
				type:"post",
				data:{"bookName":bookName,"userId":userId},
				dataType:"json",
				success:function(result){
					if(result.status==0){
						var bookId = result.data;//获得笔记本ID
						//拼一个笔记本li添加列表项----【】重复利用可以抽为一个函数，直接调用
							createBookLi(bookName,bookId)
						//关闭添加笔记对话框
						closeWindow();
						//弹出添加成功提示
						alert(result.msg);
					}
				},
				error:function(){
					alert("创建笔记本异常");
				}
			});
		}
function createBookLi(bookName,bookId){
		var sli  = '<li class="online">';
		sli += ' <a>';
		sli += ' <i class="fa fa-book" title="online" rel="tooltip-bottom"></i>'; 
		sli += bookName;
		sli += ' </a>';
		sli += '</li>';
		
		//利用data函数将bookId和sli绑定(必须是jQuery对象)
		var $li = $(sli);	//将sli字符串转成jQuery对象(加$()即可)
		//$li.data(key,name); --data函数的使用
		$li.data("bookId",bookId);	//将bookId绑定到$li对象上
		//添加到<ul id="book_list">中	
		$("#book_list").append($li);
}