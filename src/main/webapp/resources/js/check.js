/*** 登录表单检查函数 ***/
function check(f){
	// 删除错误信息
	var err = document.getElementById("err");
	err.innerHTML = "";
	
	var user = /^[a-zA-Z0-9]{2,14}$/;			//用户RegExp
	var pwd = /^[a-zA-Z0-9]{6,14}$/;				//密码RegExp
	var msg = document.getElementById("mess").getElementsByTagName("span");
	for (var i = 0; i < msg.length; i++){
		msg[i].style.display="none";	
	}
	if(!user.test(f.adusername.value)){
		msg[0].style.display="block";
		return false;
	}
	if(!pwd.test(f.adpassword.value)){
		msg[1].style.display="block";
		return false;
	}
	return true;
}