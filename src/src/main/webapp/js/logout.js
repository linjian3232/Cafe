function logout(){
	if($.removeCookie("token",{path:'/'})){
		location.reload();
	}
}

function logoutAndJump(){
	if($.removeCookie("token",{path:'/'})){
		location.href="index.html"
	}
}