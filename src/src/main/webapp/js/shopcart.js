// JavaScript Document

function onNumberChange(){
	alert(document.getElementById("1").id);
}

function addRow(){
//获取表格
    var tbody=document.getElementById("tbodyNode");
//增加一行
    var row=document.createElement("tr");
    tbody.appendChild(row);
//第一列
    var col_product=document.createElement("td");
    col_product.classList.add("row");
//产品
    var divp=document.createElement("div");
    divp.classList.add("col-md-6");
    divp.classList.add("themed-grid-col");
    col_product.appendChild(divp);
    //图片
    var pic=document.createElement("img");
    pic.src="images/3.jpg";
    pic.classList.add("img-cart");
    pic.alt="实物图";
    divp.appendChild(pic);
    //描述
    var divp=document.createElement("div");
    divp.classList.add("col-md-6");
    divp.classList.add("themed-grid-col");
    divp.classList.add("descripe");
    divp.appendChild(document.createTextNode("超级无敌小咖啡"));
    col_product.appendChild(divp);
    row.appendChild(col_product);
//价格
    var col_product=document.createElement("td");
    col_product.classList.add("table-content");
    col_product.appendChild(document.createTextNode("25"));
    row.appendChild(col_product);
//数量
    var col_product=document.createElement("td");
    var divi=document.createElement("div");
    var inp=document.createElement("input");
    inp.type="number";
    inp.classList.add("input-number");

    divi.appendChild(inp);
    col_product.appendChild(divi);
    row.appendChild(col_product);

    var col_product=document.createElement("td");
    col_product.appendChild(document.createTextNode("Cell 1,4"));
    row.appendChild(col_product);
}