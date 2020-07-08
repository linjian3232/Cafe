$('#mytab').bootstrapTable({
                method: 'get',
                url: "testdata.json", // 请求路径
                striped: true, // 是否显示行间隔色
                pageNumber: 1, // 初始化加载第一页
                pagination: true, // 是否分页
                sidePagination: 'client', // server:服务器端分页|client：前端分页
                pageSize: 5, // 单页记录数
                pageList: [5, 20, 30],
                showRefresh : true,// 刷新按钮
                queryParams: function(params) { // 上传服务器的参数
                    var temp = {
                        name: $("#sname").val(),
                        viewReason: $("#viewReason").val(),
                    };
                    return temp;
                },
                columns: [{
                    checkbox: true
                }, {
                    title: '用户id',
					cellStyle: formatTableUnit,
                    formatter: paramsMatter,
                    field: 'UserID',
                    
                },  {
                    title: '用户姓名',
                    field: 'UserName',

                },
					{
                    title: '用户密码',
                    field: 'UserPwd',

                },
					{
                    title: '用户性别',
                    field: 'UserSex',
                    formatter: formatSex
                }, {
                    title: '联系电话',
                    field: 'UserPhone'
                }, {
                    title: '用户邮箱',
                    field: 'UserEmail'
                },  {
                    title: '操作',
                    field: 'id',
                    formatter: option
                }]
            })

            // 定义删除、更新按钮
            function option(value, row, index) {
                var htm = "";
                htm += '<button id="updateinfo" UserID="' + value +
                    '" onclick="updateinfo(' + value + ')">编辑</button>'
                return htm;
            }

            //表格超出宽度鼠标悬停显示td内容
            function paramsMatter(value, row, index) {
                var span = document.createElement("span");
                span.setAttribute("title", value);
                span.innerHTML = value;
                return span.outerHTML;
            }
            //td宽度以及内容超过宽度隐藏
            function formatTableUnit(value, row, index) {
                return {
                    css: {
                        "white-space": "nowrap",
                        "text-overflow": "ellipsis",
                        "overflow": "hidden",
                        "max-width": "60px"
                    }
                }
            }

            // 格式化性别"sex": 0,是男  "sex": 1,是女
            function formatSex(value, row, index) {
                return value == 0 ? "男" : "女";
            }
          
            // 删除按钮事件
            $("#remove").on("click", function() {

                if(!confirm("是否确认删除？"))
                    return;
                var rows = $("#mytab").bootstrapTable('getSelections'); // 获得要删除的数据
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
            function updateinfo(id) {
                alert("编辑")
            }