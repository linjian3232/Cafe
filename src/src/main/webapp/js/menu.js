
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