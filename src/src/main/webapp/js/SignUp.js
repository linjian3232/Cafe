// JavaScript Document

var check_username=false;
var check_password=false;
var check_password2=false;
var check_email=false;
var check_phone=false;

function a() {
	location.href = 'Signin.html';
}

function validate_phone(phone){
	let phoneReg = /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
	if(phone==""){
		$("#test_phone").html("<font color='red' size='3px'>手机号不能为空</font>");
		check_phone=false;
	}
	else if(phone.search(phoneReg)!=-1){
		$("#test_phone").html("<font color='green' size='3px'>√ 手机号正确</font>");
		check_phone=true;
	}
	else{
		$("#test_phone").html("<font color='red' size='3px'>手机号格式错误</font>");
		check_phone=false;
	}
}
function validate_username(username) {
	if(username!=""){
		$("#test_user").html('<div id="imgWait"><img src="images/wait.gif"/></div>');
	}
	else{
		$("#test_user").html("<font color='red' size='3px'>用户名不能为空</font>");
		check_username=false;
		return;
	}
	let obj = {
		"username" : username,// 这里面定义的变量名要跟数据库里面的字段相同
	}

	$.ajax({
		url : "checkUserName.action",// 这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
		type : "POST",// 请求方式是get还是post,我这里用的是post
		async : false,
		contentType : "json",
		data : JSON.stringify(obj),// 传递的参数
		dataType : "json",
		success : function(result) { // 成功返回的回调函数
			if(result.ok=="true"){
				$("#test_user").html("<font color='green' size='3px'>√ 用户名可用</font>");
				check_username=true;
			}
			else{
				$("#test_user").html("<font color='red' size='3px'>用户名重复，请更换</font>");
				check_username=false;
			}
		}
	});
}

function validate_email(email) {
	// 定义正则表达式的变量:邮箱正则
	if(email==""){
		document.getElementById("test_email").innerHTML = ""
		check_email=false;
		return;
	}	
	let emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	// console.log(username);
	if (email.search(emailReg) != -1) {
		document.getElementById("test_email").innerHTML = "<font color='green' size='3px'>√ 邮箱格式正确</font>";
		check_email=true;
	} else {
		document.getElementById("test_email").innerHTML = "<font color='red' size='3px'>邮箱格式错误</font>";
		check_email=false;
	}
}

//验证密码是否符合要求：匹配6位密码，由数字和字母组成：
function validate_password(password) {
	// ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6-10}$
	// 测试密码：12345y
	let passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/;
	if(password==""){
		document.getElementById("test_pw").innerHTML = "<font color='red' size='3px'>密码不能为空</font>";
		check_password=false;
	}
	else if (password.search(passwordReg) != -1) {
		document.getElementById("test_pw").innerHTML = "<font color='green' size='3px'>√密码格式正确</font>";
		check_password=true;
	} else {
		document.getElementById("test_pw").innerHTML = "<font color='red' size='3px'>密码格式错误</font>";
		check_password=false;
	}
}

//验证两次输入的密码是否一样
function validate_password2(password2) {
	let password = document.getElementById("password").value;
	// 测试：console.log(password);
	// 测试：console.log(password2);
	if (password == "") {
		document.getElementById("is_test_pw").innerHTML = "";
		check_password=false;
		check_password2=false;
		return;
	} else if (password == password2) {
		document.getElementById("is_test_pw").innerHTML = "<font color='green' size='3px'>√确认密码相同</font>";
		check_password2=true;
	} else {
		document.getElementById("is_test_pw").innerHTML = "<font color='red' size='3px'>两次输入的密码不相同</font>";
		check_password2=false;
	}
}


addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}


function register() {
	
	let username = $("#username").val();
	let password = $("#password").val();
	let password2 = $("#password2").val();
	let phone = $("#tel").val();
	let needReturn=false;
	if(!check_username){
		validate_username(username);
		needReturn=true;
	}
	if(!check_password){
		validate_password(password);
		needReturn=true;
	}
	if(!check_password2){
		validate_password2(password2);
		needReturn=true;
	}
	if(!check_phone){
		validate_phone(phone);
		needReturn=true;
	}
	if(needReturn){
		alert("表单填写有误，请检查");
		return;
	}

	let gender = $("input[name='gender']:checked").val();
	if(gender==null)
		gender="";
	let birthday = $("#birthday").val();
	let email = $("#email").val();

	var obj = {
		"username" : username,// 这里面定义的变量名要跟数据库里面的字段相同
		"password" : password,
		"phone" : phone,
		"birthday" : birthday,
		"email" : email,
		"gender" :gender
	}
	$.ajax({
		url : "register.action",// 这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
		type : "POST",// 请求方式是get还是post,我这里用的是post
		contentType : "json",
		data : JSON.stringify(obj),// 传递的参数
		dataType : "json",
		success : function(result) { // 成功返回的回调函数
			if(result.ok=="true"){
				alert("注册成功！");
				location.href="Signin.html"
			}
			else{
				alert("注册失败，请重试！");
				location.reload();
			}
		}
	});
}