var data = [];
data = [
  {
    "UserID":1,
    "UserName": "玛利亚凯莉",
    "UserPwd": "19",
    "UserSex": 0,
    "UserPhone": "1567865475",
    "UserEmail": "109983@qq.com"
  },
  {
    "UserID":2,
    "UserName": "亚丽安娜",
    "UserPwd": "20",
    "UserSex": 0,
    "UserPhone": "1567865475",
    "UserEmail": "10998345@qq.com"
  },
  {
    "UserID": 3,
    "UserName": "拉娜德芮",
    "UserPwd": "19",
    "UserSex": 0,
    "UserPhone": "1567865475",
    "UserEmail": "1099834577@qq.com"
  },
  {
    "UserID": 4,
    "UserName": "凯蒂佩瑞",
    "UserPwd": "19",
    "UserSex": 0,
    "UserPhone": "1567865475",
    "UserEmail": "109983@qq.com"
  }
];
$(document).ready(function(){
	$.ajax({
		url:"getAllUser.action",
		type:"POST",
		contentType:"json",
		dataType:"json",
		data:"",
		xhrFields: { withCredentials: true },
		success:function(result){
			alert("success");
		}
	})
})
$('#table').bootstrapTable({
		method:'get',
		data:data,    // 表格数据来源
		checkbox:true,
		striped: true, // 是否显示行间隔色
        pageNumber: 1, // 初始化加载第一页
        pagination: true, // 是否分页
        sidePagination: 'client', // server:服务器端分页|client：前端分页
        pageSize: 5, // 单页记录数
        pageList: [5, 20, 30],
        showRefresh : true,// 刷新按钮
		search:false,
		columns: [
			{
				checkbox:true
			},
			{
                    title: '用户id',
					width : 110,
                    field: 'UserID',
             },
			  {
                    title: '用户姓名',
					width : 110,
                    field: 'UserName',
             },
				{
                    title: '用户密码',
					width : 100,
                    field: 'UserPwd',
                },
					{
                    title: '用户性别',
                    field: 'UserSex',
					width : 100,
                    formatter: formatSex
                }, {
                    title: '联系电话',
					width : 100,
                    field: 'UserPhone'
					
                }, {
                    title: '用户邮箱',
					width : 100,
                    field: 'UserEmail'
                }]
		})
		// 格式化性别"sex": 0,是男  "sex": 1,是女
		function formatSex(value, row, index) {
                return value == 0 ? "男" : "女";
          }
		//点击新增发生的事件
		$("#add_table_btn").click(function () 
			{
			$("#myModalLabel").text("新增");
			$('#myModal').modal();
			$("#btn_submit").click(function()
			{
			$.ajax
			({
				url:"addNewUser.action",
				type:"POST",
				dataType:"json",
				contentType:"json",
				data:{
					"UserID":$("#UserID".value),
					"UserName":$("#UserName".value),
					"UserPwd":$("#UserPwd".value),
					"UserSex":$("#UserSex".value),
					"UserPhone":$("#UserPhone".value),
					"UserEmail":$("#UserEmail".value)
				},
				success:
				function(result)
				{
					$('#table').bootstrapTable('refresh');
				}
			})
		})
});

		//点击编辑发生的事件
		$("#edit_table_btn").click(function () {
		var rows = $("#table").bootstrapTable('getSelections'); 
        if(rows.length == 0)
		{ 
        alert("请先选择要编辑的记录!");
        return;
        } 
			else
			{
				$("#myModalLabel").text("编辑");
				$('#myModal').modal();
				var id ;
				id = rows[0].UserID ;
				var uid = document.getElementById("table").rows[id].cells[1].innerText;
				var uname = document.getElementById("table").rows[id].cells[2].innerText;
				var upassword = document.getElementById("table").rows[id].cells[3].innerText;
				var usex = document.getElementById("table").rows[id].cells[4].innerText;
				var uphone = document.getElementById("table").rows[id].cells[5].innerText;
				var uemail = document.getElementById("table").rows[id].cells[6].innerText;
				$('#UserID').val(uid);
				$('#UserName').val(uname);
				$('#UserPwd').val(upassword);
				$('#UserSex').val(usex);
				$('#UserPhone').val(uphone);
				$('#UserEmail').val(uemail);
				$('#btn_submit').click(function(){
					alert(id);
					document.getElementById("table").rows[id].cells[1].innerText = $('#UserID').val();
					document.getElementById("table").rows[id].cells[2].innerText = $('#UserName').val();
					document.getElementById("table").rows[id].cells[3].innerText = $('#UserPwd').val();
					document.getElementById("table").rows[id].cells[4].innerText = $('#UserSex').val();
					document.getElementById("table").rows[id].cells[5].innerText = $('#UserPhone').val();
					document.getElementById("table").rows[id].cells[6].innerText = $('#UserEmail').val();
				})
			}
	})
		function submit(){
			var tabLen = document.getElementById("table");
            var jsonT = "[";
            for (var i = 1; i < tabLen.rows.length; i++) {
                    jsonT += 
					'{"UserID":' + tabLen.rows[i].cells[1].innerHTML + 
						',"UserName":"' + tabLen.rows[i].cells[2].innerHTML +
						'","UserPwd":"' + tabLen.rows[i].cells[3].innerHTML +
						'","UserSex":"' + tabLen.rows[i].cells[4].innerHTML + 
						'","UserPhone":"' + tabLen.rows[i].cells[5].innerHTML +
						'","UserEmail":"' + tabLen.rows[i].cells[6].innerHTML
						+ '"},'
            }
            jsonT= jsonT.substr(0, jsonT.length - 1);
            jsonT += "]";
			
			$.ajax({
				url:"changeUserData.action",
				contentType:"json",
				dataType:"json",
				data:jsonT,
				type:"POST",
				success:function(result)
				{
					$('#table').bootstrapTable('refresh');
				}
			})
		}
			//点击删除发生的事件
			$("#delete_table_btn").on("click", function() {
                if(!confirm("是否确认删除？"))
                    return;
                var rows = $("#table").bootstrapTable('getSelections'); // 获得要删除的数据
                if(rows.length == 0) { // rows 主要是为了判断是否选中，下面的else内容才是主要
                    alert("请先选择要删除的记录!");
                    return;
                } else {
                    var ids = new Array(); // 声明一个数组
                    $(rows).each(function() { // 通过获得别选中的来进行遍历
                        ids.push(this.UserID); // cid为获得到的整条数据中的一列
                    });
                    //后端删除的方法
					
                    deleteMs(ids);
                }
            })

            // 删除访客,删除数据库内容，刷新表格即可删除
            function deleteMs(ids) {
                $.ajax({
                    url: "deleteUser.action",//需要修改URL
                    dataType: "json",
					type : "POST",
					data : {
						"ids" : ids
					},
                    success: function(data) {
                        if(data.message == "OK") {
                            alert("删除成功")
                            $('#table').bootstrapTable('refresh');
                        }
                    }
                });
            }