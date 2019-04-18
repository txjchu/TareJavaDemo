//页面加载后执行function；
//效果类似于onload事件。
$(function(){
	//给button绑定单击事件，
	//单击时调用匿名函数。
	$("button").click(function(e){
		//匿名函数中可以直接写代码，
		//也可以调用其他预置的函数。
		hello();
		//1.jQuery后绑定事件要想传入event，
		//需要通过匿名函数来实现；
		//2.传入的事件对象e不是浏览器提供的
		//原始的event，而是jQuery封装后的对象。
		//3.所以e对象的属性和方法有一定的变化。
		alert(e.pageX + "," + e.pageY);
		console.log(e.target);
	});
	//给所有的div绑定单击事件
	$("div").click(function(e){
		//jQuery后绑定事件时，可以在绑定函数
		//内通过this获取当前事件触发的目标。
		//即this=本次单击对应的目标(dom)
		alert(this.id);
		//取消事件冒泡
		e.stopPropagation();
	});
});

function hello() {
	alert("jQuery真好");
}


