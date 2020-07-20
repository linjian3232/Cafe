function search(){
	alert("1111");
	$.ajax({
		url:"",
		method:"POST",
		dataType:"text",
		data:{
		"UserID":$("#UserID").val()
	},
		success:
		function(data)
		{
			$.each(data.data,function(index,item){
                var tr;
				tr='<td>'+item.orderid+'</td>'+'<td>'+item.ordertime+'</td>'+'<td>'+item.orderstatus+'</td>';
                    $("#order").append('<tr>'+tr+'</tr>')
                })
		}
	}
	)
}