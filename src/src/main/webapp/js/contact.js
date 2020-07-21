$(document).ready(function(){
    $.ajax({
        url:"getPersonInfo.action",
        type:"POST",
        contentType:"json",
        xhrFields: { withCredentials: true },
        dataType:"json",
        data:"",
        success:function(result){
			console.log(result.ok);
            if(result.ok!=null&&result.ok=="false"){
                location.href="index.html";
                return;
            }
            
            
        },
        fail:function(){
            location.href="index.html";
        }
    })
});