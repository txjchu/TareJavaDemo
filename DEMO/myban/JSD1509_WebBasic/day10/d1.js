//页面加载后执行function
//效果类似于onload事件【】
$(function(){
	//给button绑定单击事件，单击时调用匿名函数。
	$("button").bind("click",function(e){		//------尽量传入函数
	
	//$("button").click(function(e){});-----第二种写法
	//匿名函数中可以直接写代码，也可以调用其他预置的函数。
	
		hello();
		//1.jQuery后绑定事件要想传入event,需要通过匿名函数来实现。	
		//2.传入的事件对象e不是浏览器提供的原始的event,而是jQuery封装后的对象。
		//3.所以e对象的属性和方法有一定的变化。
		
//		alert("jQuery真好！");
		
		alert(e.pageX+","+e.pageY);		//----获取点击鼠标时坐标
		console.log(e.target);				//----获取事件源
		
	});	
	//给所有的div绑定单击事件
	$("div").click(function(e){
		//要求输出当前点击div的id
		//jQuery后绑定事件时，可以在绑定函数内通过this获取当前事件触发的目标。	即this=本次单击对应的div----和e.target不同
		alert(this.id);		//----this是dom对象。-----事件的冒泡，输出了事件对象，并产生事件的传播。
		//取消事件冒泡
		e.stopPropagation();
	});
});

function hello(){
	alert("jQuery真好！");
}