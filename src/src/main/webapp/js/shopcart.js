// JavaScript Document

function onNumberChange(){
    var parent=arguments[0];
    var price=parent.nextElementSibling;
    var total=price.nextElementSibling;
    console.log(arguments[1]);
    console.log(Number(price.innerHTML));
    total.innerHTML=Number(price.innerHTML)*arguments[1];
    console.log(total);
}
function del(){
    var tbody=document.getElementById("tbodyNode");
    tbody.removeChild(document.getElementById("wudidakafei"));
    //TODO 还要做数据库的相关操作
}
/**增加一行购物车数据
 * @param foodId
 * @param foodName
 * @param food
 */

function addRow(foodId,foodName,foodPrice){
//TODO 参数替换
//获取表格
    var tbody=document.getElementById("tbodyNode");
//查重
    for(i=0;i<tbody.childNodes.length;i++){
        if(tbody.childNodes[i].nodeType==1){
            if(tbodyNode.childNodes[i].id==foodId)
;
        }
    }
//增加一行
    var row=document.createElement("tr");
//图片
    var col_pic=document.createElement("td");
    var pic=document.createElement("img");
    pic.alt="实物图";
    pic.src="images/3.jpg";
    col_pic.appendChild(pic);
    row.appendChild(col_pic);
//名称
    var col_name=document.createElement("td");
    col_name.appendChild(document.createTextNode("超级无敌小咖啡"))
    row.appendChild(col_name);
//数量
    var col_quantity=document.createElement("td");
    var inp=document.createElement("input");
    inp.type="number";
    inp.value="1";
    inp.min="1";
    inp.onChange="addRow()";

    col_quantity.appendChild(inp);
    row.appendChild(col_quantity);
//价格
    var col_price=document.createElement("td");
    col_price.appendChild(document.createTextNode("24"));
    row.appendChild(col_price);
//价格小计
    var col_total=document.createElement("td");
    col_total.appendChild(document.createTextNode("100"));
    row.appendChild(col_total);
//操作
    var col_operation=document.createElement("td");
    col_operation.appendChild(document.createTextNode("删除"));
    row.appendChild(col_operation);

    tbody.appendChild(row);
}