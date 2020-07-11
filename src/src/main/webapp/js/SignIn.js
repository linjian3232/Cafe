// JavaScript Document
function SignIn() {
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;

    if(userName==""){
        alert("请输入用户名！");
        return;
    }
	if(password="")
		{
			 alert("请输入密码！");
        return;
		}

var obj={
        "userName":userName,//这里面定义的变量名要跟数据库里面的字段相同
        "password":password,

    }
    $.ajax({
        url:"http://"+window.location.host+"SignIn",//这里是你接口的路径，记住http://不要忘记,localhost是你本地的地址，如果要请求别人的请将别人的ip地址替换，后面的addInfoPerson是接口名字。
        type:"POST",//请求方式是get还是post,我这里用的是post
        contentType:"application/json",
        data:JSON.stringify(obj),//传递的参数
        dataType:"json",
        success:function(){ //成功返回的回调函数
            alert("登录成功");
        }
     });
}
addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}