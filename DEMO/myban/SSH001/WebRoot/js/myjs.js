//退出
function exitFee(){
	var r = window.confirm("您确定要退出系统吗？");
	//console.log(admin);
	if(!r) return;
	window.location.href = "exit.action";
}
