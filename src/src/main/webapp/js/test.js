// JavaScript Document
// JavaScript Document
function a() { location.href = 'Sign in.html'; }
//注册
function register() {

	var uname = $("input[name='username']").val();

	var uName = $("input[name='name']").val();

	var upwd = $("input[name='password']").val();

	$.ajax({

		type: "post",

		url: "*",

		data: {

			'userEmail': uname,

			'passwd': upwd,

			'uName': uName,

			'icon': "../images/3.jpg"

		},

		dataType: "json",

		success: function(data) {

			if (data["msg"] == "true") {

				$('.register-close').click();

				$.ajax({

					type: "post",

					url: "*",

					data: {

						'email': uname,

						'password': upwd

					},

					dataType: "json",

					success: function(data) {

						if (data['uName'] != undefined) {

							$('.login-close').click();

							swal("注册成功", "已自动登录", "success");

							var html = '';

							html = '<img src="' + data['icon'] + '" alt="" class="img-circle" style="width:2em;height:2em;margin-top:0.7em;display:inline"/><a href="javascript:;" οnclick="userlogin()" class="nav-text" style="top:0.6em;display:inline">' + data['uName'] + '欢迎您！</a><p class="hidden checklogin">NO</p><p class="hidden useremail"></p><p class="hidden userimg"></p>';

							document.getElementById('usershow').innerHTML = html;

							$('.checklogin').text(data['userId']);

							$('.useremail').text(data['userEmail']);

							$('.userimg').text(data['icon']);

							document.cookie = "uid=" + data['userId'] + " uname=" + escape(data['uName']) + " email=" + escape(data['userEmail']) + " icon=" + escape(data['icon']);

						}

					}

				});

			} else if (data["msg"] == "该账号已被注册！") {

				swal({

					title: "对不起",

					text: "该账号已被注册",

					type: "warning"

				});

			} else if (data["msg"] == "false") {

				swal({

					title: "对不起",

					text: "出现未知错误，请重新注册",

					type: "warning"

				});

			} else {
				location.href = 'Sign in.html';


			}

		}

	});

}

function validate_username(username) {

	//定义正则表达式的变量:邮箱正则

	var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	//console.log(username);

	if (username != "" && username.search(emailReg) != -1) {

		document.getElementById("test_user").innerHTML = "<font color='#CCFF99' size='3px'>√邮箱格式正确</font>";

	} else {

		document.getElementById("test_user").innerHTML = "<font color='red' size='3px'>邮箱格式错误</font>";

	}

}



//函数2：验证密码是否符合要求：匹配6位密码，由数字和字母组成：

function validate_password(password) {

	//^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6-10}$

	//测试密码：12345y

	var passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6}$/;

	if (password != "" && password.search(passwordReg) != -1) {

		document.getElementById("test_pw").innerHTML = "<font color='#CCFF99' size='3px'>√密码格式正确</font>";

	} else {

		document.getElementById("test_pw").innerHTML = "<font color='red' size='3px'>密码格式错误</font>";

		alert("密码有6位，由数字和字母组成!");

	}

}



//函数3：验证两次输入的密码是否一样

function validate_password2(password2) {

	var password = document.getElementById("password").value;

	//测试：console.log(password);

	//测试：console.log(password2);

	if (password == "") {

		document.getElementById("is_test_pw").innerHTML = "<font color='red' size='3px'>密码不为空</font>";

	} else if (password == password2) {

		document.getElementById("is_test_pw").innerHTML = "<font color='#CCFF99' size='3px'>√确认密码相同</font>";

	} else {

		document.getElementById("is_test_pw").innerHTML = "<font color='red' size='3px'>两次输入的密码不相同</font>";

		console.log("密码有6位，由数字和字母组成!");

	}

}



//函数4：验证表单是否已经填好

function validate_form() {

	var username = document.getElementById("username").value;

	var password = document.getElementById("password").value;

	var password2 = document.getElementById("password2").value;

	//console.log("表单填写正确，可以正常提交！");



	//这三个，如果任何一个有问题，都返回false

	//18128@qq.com		12345y

	var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	var passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6}$/;



	if (username != "" && emailReg.test(username)) {

		if (password != "" && passwordReg.test(password)) {

			if (password2 == password) {

				alert("信息填写正确，可以正常提交！");

				console.log("信息填写正确，可以正常提交！");


				return true;

			} else {

				alert("密码不一致，提交失败，请重新填写！");

				console.log("密码不一致，提交失败，请重新填写！");

				return false;

			}

		} else {


			alert("密码格式错误，提交失败，请重新填写！");

			console.log("密码格式错误，提交失败，请重新填写！");

			return false;

		}

	} else {

		alert("注册的账号不符合要求，提交失败，请重新填写！");

		console.log("注册的账号不符合要求，提交失败，请重新填写！");

		return false;

	}

}

addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
	window.scrollTo(0, 1);
}