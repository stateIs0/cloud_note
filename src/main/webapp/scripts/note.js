/*
 *
 *笔记的脚本
 *
 */

function loadNoteAction(){
	console.log("loadNoteAction");
	var index=$(this).data("index");
	
	model.notebookIndex=index;
	if(!model.notePageNum){
		model.notePageNum=0;
	}else{
		model.notePageNum++;
	}
	var url="note/list.do";
	var param={notebookId:model.notebooks[index].id,pageNum:model.notePageNum};
	
	$('#notebooks li a').removeClass('checked');
	$(this).find('a').addClass('checked');
	
	$.getJSON(url,param,function(result){
		if(result.state==SUCCESS){
			var notes=result.data;
			model.updateNoteView(notes);
		}else{
			alert(result.msg);
		}
	});
}

model.updateNoteView=function(notes){
	if(notes){
		model.notes=notes;
	}
	console.log(notes);
	var Template=	' <li class="online note">'
					+'<a  class="">'
					+'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>#title<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>'
					+'</a>'
					+'<div class="note_menu" tabindex="-1">'
					+'<dl>'
					+'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>'
					+'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>'
					+'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>'
					+'</dl>'
					+'</div>'
					+'</li>';
		
	var ul=$("#notes").empty();
	for(var i=0;i<this.notes.length;i++){
		var li=$(Template.replace("#title",model.notes[i].title));
		console.log(model.notes[i].title);
		li.data("index",i);
		ul.append(li);
	}
}


function getAction(){
	$('#notes li a').removeClass('checked');
	$(this).find('a').addClass('checked');
	console.log("getAction");
	var url="note/get.do";
	model.noteIndex=$(this).data("index");
	var param={noteId:model.notes[$(this).data("index")].id};
	$.getJSON(url,param,function(result){
		if(result.state==0){
			var data=result.data;
			model.updateNote(data);
		}
	});
}

model.updateNote=function(data){
	console.log("updateNote");
	$("#input_note_title").val(data.title);
	um.setContent(data.body);
	model.note=data;
}

/*
 * 保存笔记
 */
function saveAction(){
	console.log("saveAction");
	var url="note/save.do";
	var noteId=model.note.id;
	var title=$("#input_note_title").val();
	var body=um.getContent();
	var param={noteId:noteId,title:title,body:body};
	$.post(url,param,function(result){
		if(result.state==SUCCESS){
			if(result.data){
				model.notes[model.noteIndex].title=title;
				model.updateNoteView();
			}
		}else{
			alert(result.msg);
		}
	});
}

function addNoteAction(){
	//console.log('addNoteAction');
	var url='note/add.do';
	var notebookId=
	model.notebooks[model.notebookIndex].id;
	var param = {
		notebookId: notebookId,
		userId: getCookie('userId'),
		title: $('#input_note').val()
	};
	
	var btn=$(this).attr('disabled','disabled')
		.html('创建中...');
	$.post(url, param, function(result){
		if(result.state==SUCCESS){
			var note = result.data;
			//console.log(title);
			//在数组的第一个位置插入新笔记
			model.notes.unshift(
				{id:note.id, title:note.title});
			model.noteIndex=0;
			//更新笔记编辑区域
			model.updateNote(note);
			//更新笔记列表区域
			model.updateNoteView();
			
			setTimeout(function(){
				btn.removeAttr('disabled').
					html('创建');
				closeAction();
			},1000);
		}else{
			alert(result.message);
		}
	});
}

























