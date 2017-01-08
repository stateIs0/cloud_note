
//定义ajax状态.
var SUCCESS=0;
var ERROR=1;

//定义存放数据模型
var model={};

$(function (){
	console.log("js");
	loadNotebookAction();
	//加载笔记本列表
	$("#notebooks").on("click",".more",loadNotebookAction);
	//加载笔记列表
	$("#notebooks").on("click",".notebook",loadNoteAction);
	//加载笔记内容
	$("#notes").on("click","li",getAction);
	//更新笔记
    $("#save_note").click(saveAction);
    
	$('#add_note').click(showNoteDialogAction);
	
})

function showNoteDialogAction(){
	
	if(!model.notebooks[model.notebookIndex]){
		return;
	}
	
	$('#can').load('alert/alert_note.html',
			function(){
		$('.opacity_bg').show();
		$('#can .sure').click(addNoteAction);
	});
}

function closeAction(){
	$('#can').empty();
	$('.opacity_bg').hide();
}