/*
 * 笔记本的脚本
 */
function loadNotebookAction(){
	console.log("loadNotebookAction");
	
	var url="notebook/list.do";
	if(!model.pageNum){
		model.pageNum=0;
	}else{
		model.pageNum++;
	}
	
	
	var param={userId:getCookie("userId"),pageNum:model.pageNum};
	$.getJSON(url,param,function(result){
		if(result.state==SUCCESS){
			console.log("success");
			var notebooks=result.data;
			model.updateNotebookView(notebooks);
		}
	})
	
};

model.updateNotebookView=function(notebooks){
	console.log("updateNotebookView");
	if(!model.notebooks){
		model.notebooks=notebooks;
	}else{
		model.notebooks=model.notebooks.concat(notebooks);
	}
	var ul=$("#notebooks").empty();
	var Template='<li class="online notebook">'
					+'<a>'
					+'<i class="fa fa-book" title="online" rel="tooltip-bottom">'
					+'</i> #name</a></li>';
	for(var i=0;i<model.notebooks.length;i++){
		var notebook=this.notebooks[i];
		var li=$(Template.replace("#name",notebook.name));
		ul.append(li);
		li.data("index",i);
	}
	var li="<li class='online more'><a>more...</a></li>";
	ul.append(li);
	
	
	
	
	
	
	
	
	
	
	
	
	
}