
function changeSelect(checked,type){
    if(checked==false){
        type.hidden=true;
    }
    else{
        type.hidden=false;
    }
}

function searchName(value){
    var root=document.getElementByClassName("no-gutters");
    for(int i=0;i<root.length;i++){
        if(root.h6.indexOf(value)!=-1){
            root.hidden=false;
        }
        else{
            root.hidden=true;
        }
    }
}