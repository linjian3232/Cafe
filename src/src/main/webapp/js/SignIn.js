// JavaScript Document

function SignIn() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var usertype;
	if($("input[name='type']:checked").val()==1){
		usertype="user";
	}
	else if($("input[name='type']:checked").val()==2){
		usertype="admin";
	}
	else{
		alert("请选择用户类型！");
		return;
	}
	if (username == "") {
		alert("请输入用户名！");
		return;
	}
	if (password == "") {
		alert("请输入密码！");
		return;
	}
	$.ajax({
		url: "login.action",//这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
		type: "POST",//请求方式是get还是post,我这里用的是post
		contentType: "json",
		dataType: "json",
		data:JSON.stringify({
			"username":username,
			"password":password,
			"usertype":usertype,
		}),
		success: function(result) { //成功返回的回调函数
			var obj=result;
			if(obj.token!=""){
				setToken(obj.token,obj.userType);
			}
			else{
				alert("账号或密码错误，请重试");
			}
		}
	});
}
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
	window.scrollTo(0, 1);
}

function setToken(token,usertype) {
	var date = new Date();
	date.setTime(date.getTime()+1000*60*15-10*1000);
	$.cookie('token',token,{
		expires:date,
		path:'/'
	});
	$.cookie('userType',usertype,{
		expires:date,
		path:'/'
	});
	location.href="index.html";
}