var imgURL;//用于传输图片的地址
/*
 * 图片上传
 */
$("#uploadImage").fileinput({
    'language': 'zh',
    'fileSingle':'file',
    'theme' : 'fa',
    'previewFileType': 'image',
    'uploadUrl' : 'uploadPic.action',
    'enctype' : 'multipart/form-data',
    'allowedFileTypes': ['image'],
    'allowedFileExtensions': ['jpg', 'jpeg', 'png'],//接收的数据类型
    'uploadAsync': true, //默认异步上传
    'showUpload': true,//是否显示上传按钮
    'showRemove': true,//显示移除按钮
    'showPreview': true, //是否显示预览
    'browseClass': "btn btn-info", //按钮样式   
    'dropZoneEnabled': true,
    'minFileCount': 1,
    'maxFileCount': 1,
    'maxFileSize': 5000,
    'autoReplace': true,
}).on('fileuploaded', function (event, data) {
    var response = data.response;
    alert(response.msg);
    if (response.result == 'ok') {
        imgURL = response.imgURL;
        //document.getElementById("img").value = response.url;
    }
}).on("filebatchselected", function () {
    $(this).fileinput("upload");
});
/*
 * 发布商品（提交表单）
 */

function addMenu() {
    alert(imgURL);
    $.ajax({
        url: "addMenuList.action",
        type: "POST",
        dataType: "text",
        data: {
            "goods_name": $("#goods_name").val(),
            "goods_type": $("#goods_type").val(),
            "goods_stock": $("#goods_stock").val(),
            "goods_price": $("#goods_price").val(),
            "goods_unit": $("#goods_unit").val(),
            "goods_image": imgURL,
        },
        success: function (data) {
            if (data.message == "OK")
                alert("上传成功！");
        },
        error: function (e) {
            alert("出错");
            alert(e.responseText);
        },
    })
}
