$('#table').bootstrapTable({
		method:'get',
		url : 'testdata.json',        // 表格数据来源
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
                    title:'id',
                    field: 'id',
					visible:false
             },  {
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
		$("#add_table_btn").click(function () {
			$("#myModalLabel").text("新增");
			$('#myModal').modal();
			$.ajax
			(
			{
				url:"url",
				type:"POST",
				dataType:"json",
				data:{
					"UserID":$("#UserID".value),
					"UserName":$("#UserName".value),
					"UserPwd":$("#UserPwd".value),
					"UserSex":$("#UserSex".value),
					"UserPhone":$("#UserPhone".value),
					"UserEmail":$("#UserEmail".value),
				},
				success:
				function(data)
				{
					
				}
			});
			
		});
		
		//点击编辑发生的事件
		$("#edit_table_btn").click(function () {
		var rows = $("#table").bootstrapTable('getSelections'); // 获得要删除的数据
        if(rows.length == 0) { 
        alert("请先选择要编辑的记录!");
        return;
        } 
			else
			{
				$("#myModalLabel").text("编辑");
				$('#myModal').modal();
				var id = rows[0].id+1 ;
				var originid = rows[0].UserID;
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
				$.ajax
			(
			{
				url:"url",
				type:"POST",
				dataType:"json",
				data:{
					"originID":originid,
					"UserID":$("#UserID".value),
					"UserName":$("#UserName".value),
					"UserPwd":$("#UserPwd".value),
					"UserSex":$("#UserSex".value),
					"UserPhone":$("#UserPhone".value),
					"UserEmail":$("#UserEmail".value)
				},
				success:
				function(data)
				{
					
				}
			});
			}
	})
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
                    deleteMs(ids)
                }
            })

            // 删除访客,删除数据库内容，刷新表格即可删除
            function deleteMs(ids) {
                $.ajax({
                    url: basePath + "/caller/dels?ids=" + ids,//需要修改URL
                    dataType: "json",
					type : "POST",
					data : {
						"ids" : ids
					},
                    success: function(data) {
                        if(data.message == "OK") {
                            alert("删除成功")
                            $('#mytab').bootstrapTable('refresh', {
                                url: basePath + '/caller/list'		//需要修改URL
                            });
                        }
                    }
                });
            }
            // 编辑访客