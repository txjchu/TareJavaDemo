/* 联动下拉选获取json数据并自动设置下拉选的方法 */
function addOption(selectValue, uri, id){//selectValue 更改选项的下拉选后当前选项的value；uri 将要创建的请求路径；id 准备接收数据的下拉选的id.
	var xhr = getXhr();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var txt = xhr.responseText;//获取到服务器发过来的jsonStr
			var jsObj = txt.evalJSON();//将jsonStr转变为js对象
			$(id).innerHTML = "";//将要添加下拉选的select中的内容清空。
			for(var i = 0; i < jsObj.length; i++){//遍历jsObj集合或数组
				var op = new Option(jsObj[i].name, jsObj[i].value);
				$(id).options[i] = op;//向下拉选的options中添加Option元素对象
			}
		}		
	}; 
	xhr.open("post", uri, true);
	xhr.setRequestHeader("content-type",'application/x-www-form-urlencoded');//post请求需要设置消息头信息
	xhr.send("name="+ selectValue);
}

/* 便捷获取元素的方法 */
function $(id){
	return document.getElementById(id);
}
/* 便捷读取元素value值的方法:根据id获取元素的value的值 */
function $F(id){
	return $(id).value;
}

/* 获取Ajax对象的方法 */
function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActionXObject("Microsoft.XMLHttp");
	}
	return xhr;
}