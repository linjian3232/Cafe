
function changeSelect(checked,type){
    if(checked==false){
        type.hidden=true;
    }
    else{
        type.hidden=false;
    }
}

function searchName(value){
    var root=document.getElementsByClassName("no-gutters");
    console.log(root.length);

    for(i=0;i<root.length;i++){
        var str=String(root[i].childNodes[1].innerHTML);
        if( str.indexOf(value)!=-1){
            root[i].parentNode.hidden=false;
        }
        else{
            root[i].parentNode.hidden=true;
        }
    }
}

function createMenu(data){
    for(i=0;i<data.length;i++){
        var id=date[i].id;
        var src=data[i].src;
        var name=data[i].name;
        var price=data[i].price;
        var type;
		switch(data[i].type){
			case '1':type="coffee";break;
			case '2':type="snack";break;
		}
        addOne(src,name,price,type);
    }
}
function addOne(src,name,price,type){
    var div =document.createElement("div");
    div.innerHTML='<div><div><img src="'+src+'"class="img-fluid img-style" alt="restaurant"></div>'+
				  '<div class="row no-gutters"><h6>'+name+' ￥'+price+'</h6>'+
				  '<div class="col-lg-6 col-6"><div class="choose-food-btn text-right">'+
				  '<a href="#" title="add" class="btn btn-success">加入购物车</a>'+
				  '</div></div></div></div>';
    var root=document.getElementById(type);
    root.childNodes[3].appendChild(div);
}
var food1={
    "id":"wudikafei2",
    "src":"images/menu2.jpg",
    "name":"大咖啡2",
    "price":"202",
    "type":"coffee"
}
=======

function changeSelect(checked,type){
    if(checked==false){
        type.hidden=true;
    }
    else{
        type.hidden=false;
    }
}

function searchName(value){
    var root=document.getElementsByClassName("no-gutters");
    console.log(root.length);

    for(i=0;i<root.length;i++){
        var str=String(root[i].childNodes[1].innerHTML);
        if( str.indexOf(value)!=-1){
            root[i].parentNode.hidden=false;
        }
        else{
            root[i].parentNode.hidden=true;
        }
    }
}

function createMenu(data){
    for(i=0;i<data.length;i++){
        var id=date[i].id;
        var src=data[i].src;
        var name=data[i].name;
        var price=data[i].price;
        var type=data[i].type;
        addOne(src,name,price,type);
    }
}
function addOne(src,name,price,type){
    var div =document.createElement("div");
    div.innerHTML='<div><div><img src="'+src+'"class="img-fluid img-style" alt="restaurant"></div>'+
				  '<div class="row no-gutters"><h6>'+name+' ￥'+price+'</h6>'+
				  '<div class="col-lg-6 col-6"><div class="choose-food-btn text-right">'+
				  '<a href="#" title="add" class="btn btn-success">加入购物车</a>'+
				  '</div></div></div></div>';
    var root=document.getElementById(type);
    root.childNodes[3].appendChild(div);
     $.ajax({
    	        type: "POST",
    	        url: "getMenuList.action",
    		contentType:"application/x-www-form-urlencoded",  
    		data:{"a":"b"},
    	        success: function (data) {
    		
    	        }
    	    });
}
var food1={
    "id":"wudikafei2",
    "src":"images/menu2.jpg",
    "name":"大咖啡2",
    "price":"202",
    "type":"coffee"
}
