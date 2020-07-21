var data = [];
data = [
	{
		"orderid":1,
		"ordertime":'0202',
		"orderstatus":"buying"
	},
	{
		"orderid":1,
		"ordertime":'0202',
		"orderstatus":"buying"
	},
	{
		"orderid":1,
		"ordertime":'0202',
		"orderstatus":"buying"
	}
]
function test()
		{
			var ht = '';
  			for(var i=0;i<data.length;i++){//循环json对象，拼接tr,td的html
				ht = ht+'<tr>';
				ht = ht + '<th>' + data[i].orderid + '</th>';
				ht = ht + '<th>' + data[i].ordertime + '</th>';
				ht = ht + '<th>' + data[i].orderstatus + '</th>';
				ht = ht+'</tr>';
			}
  $('#order').append(ht);
		}

function search(){
	$.ajax({
		url:"searchOrder.action",
		method:"POST",
		dataType:"text",
		data:{
		"UserID":$("#UserID").val()
	},
		success:
		function(data)
		{
			var ht = '';
  			for(var i=0;i<data.length;i++){//循环json对象，拼接tr,td的html
				ht = ht+'<tr>';
				ht = ht + '<th>' + data[i].orderid + '</th>';
				ht = ht + '<th>' + data[i].ordertime + '</th>';
				ht = ht + '<th>' + data[i].orderstatus + '</th>';
				ht = ht+'</tr>';
			}
  $('#order').append(ht);
		}
	}
	)
}