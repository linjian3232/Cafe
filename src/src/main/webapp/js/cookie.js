// JavaScript Document

$(function(){
	let date=new Date();
	
	date.setTime(date.getTime()+1000*60*2);
	$.cookie('userid','10002',{
		expires:date
	});
	let userId=$.cookie('userid');
	window.console.log(userId);
});
